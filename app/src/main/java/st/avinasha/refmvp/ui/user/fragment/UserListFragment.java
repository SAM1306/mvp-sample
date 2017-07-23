package st.avinasha.refmvp.ui.user.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import st.avinasha.refmvp.R;
import st.avinasha.refmvp.dagger.component.FragmentComponent;
import st.avinasha.refmvp.mvp.BasePresenterFragment;
import st.avinasha.refmvp.net.model.user.User;
import st.avinasha.refmvp.ui.base.FragmentListener;
import st.avinasha.refmvp.ui.user.fragment.adapter.UserListAdapter;
import st.avinasha.refmvp.ui.user.fragment.dagger.module.UserListModule;
import st.avinasha.refmvp.ui.user.fragment.presentation.UserListPresentation;
import st.avinasha.refmvp.ui.user.fragment.presenter.UserListPresenter;

public class UserListFragment extends BasePresenterFragment implements UserListPresentation {

    @BindView(R.id.tv_error) TextView mTxtError;
    @BindView(R.id.ll_progress) View mProgress;
    @BindView(R.id.rv_users) RecyclerView mRvUsers;

    @Inject FragmentListener mFragmentListener;
    @Inject RecyclerView.LayoutManager mLinearLayoutManager;
    @Inject UserListPresenter mUserListPresenter;
    @Inject UserListAdapter mUserListAdapter;

    public static UserListFragment newInstance() {
        return new UserListFragment();
    }

    public UserListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(mUserListPresenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_users, container, false);
        bindViews(rootView);

        mRvUsers.setLayoutManager(mLinearLayoutManager);
        mRvUsers.setAdapter(mUserListAdapter);
        return rootView;
    }

    @Override
    protected void resolveDependencies(FragmentComponent fragmentComponent) {
        super.resolveDependencies(fragmentComponent);
        fragmentComponent.userListComponent(new UserListModule(this))
                .inject(this);
    }

    // region Presentation methods.
    @Override
    public void hideViews() {
        mTxtError.setVisibility(View.GONE);
        mProgress.setVisibility(View.GONE);
        mRvUsers.setVisibility(View.GONE);
    }

    @Override
    public void displayError(@StringRes int msgId) {
        mTxtError.setVisibility(View.VISIBLE);
        mTxtError.setText(msgId);
    }

    @Override
    public void loadUsers(@NonNull List<User> users) {
        mRvUsers.setVisibility(View.VISIBLE);
        mUserListAdapter.setUserList(users);
    }

    @Override
    public void showProgress(boolean show) {
        mProgress.setVisibility(show ? View.VISIBLE : View.GONE);
    }
    // endregion Presentation methods.
}
