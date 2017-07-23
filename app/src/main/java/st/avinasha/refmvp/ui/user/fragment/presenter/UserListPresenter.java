package st.avinasha.refmvp.ui.user.fragment.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import st.avinasha.refmvp.R;
import st.avinasha.refmvp.dagger.annotation.PerFragment;
import st.avinasha.refmvp.mvp.BaseFragmentPresenter;
import st.avinasha.refmvp.net.model.user.User;
import st.avinasha.refmvp.net.repository.UserRepository;
import st.avinasha.refmvp.rx.CommonSchedulers;
import st.avinasha.refmvp.ui.user.fragment.presentation.UserListPresentation;

@PerFragment
public final class UserListPresenter extends BaseFragmentPresenter {

    private static final String TAG = UserListPresenter.class.getName();

    private UserListPresentation mUserListPresentation;
    private CompositeDisposable mCompositeDisposable;
    private CommonSchedulers mCommonSchedulers;
    private UserRepository mUserRepository;

    @Inject
    UserListPresenter(@NonNull UserListPresentation userListPresentation,
                      @NonNull CompositeDisposable compositeDisposable,
                      @NonNull CommonSchedulers commonSchedulers,
                      @NonNull UserRepository userRepository) {
        mUserListPresentation = userListPresentation;
        mCompositeDisposable = compositeDisposable;
        mCommonSchedulers = commonSchedulers;
        mUserRepository = userRepository;
    }

    @Override
    public void onStart() {
        super.onStart();
        getUsers();
    }

    @Override
    public void onStop() {
        super.onStop();
        mUserListPresentation.showProgress(false);
        mCompositeDisposable.clear();
    }

    @VisibleForTesting
    void getUsers() {
        mUserListPresentation.showProgress(true);
        mCompositeDisposable.add(mUserRepository.getUsers()
            .compose(mCommonSchedulers.<List<User>>getIoToMainScheduler())
            .subscribe(
                    new Consumer<List<User>>() {
                           @Override
                           public void accept(List<User> users) throws Exception {
                               handleGetUsersSuccess(users);
                           }
                       },
                    new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            handleGetUsersError(throwable);
                        }
                    }));
    }

    @VisibleForTesting
    void handleGetUsersSuccess(@NonNull List<User> users) {
        Log.d(TAG, "Fetched users successfully !");
        mUserListPresentation.showProgress(false);
        if (users.isEmpty()) {
            mUserListPresentation.displayError(R.string.no_users);
            return;
        }
        mUserListPresentation.loadUsers(users);
    }

    @VisibleForTesting
    void handleGetUsersError(Throwable throwable) {
        Log.e(TAG, "Error in fetching users:", throwable);
        mUserListPresentation.showProgress(false);
        mUserListPresentation.displayError(R.string.error_user);
    }
}
