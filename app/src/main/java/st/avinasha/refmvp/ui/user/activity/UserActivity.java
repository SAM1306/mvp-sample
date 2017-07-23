package st.avinasha.refmvp.ui.user.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import st.avinasha.refmvp.R;
import st.avinasha.refmvp.dagger.component.ActivityComponent;
import st.avinasha.refmvp.mvp.BasePresenterActivity;
import st.avinasha.refmvp.ui.user.activity.dagger.component.UserComponent;
import st.avinasha.refmvp.ui.user.activity.dagger.module.UserModule;
import st.avinasha.refmvp.ui.user.activity.presentation.UserPresentation;
import st.avinasha.refmvp.ui.user.activity.presenter.UserPresenter;
import st.avinasha.refmvp.ui.user.fragment.UserListFragment;

public class UserActivity extends BasePresenterActivity implements UserPresentation {

    private UserComponent mUserComponent;

    @Inject UserPresenter mUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        setFragmentContainerId(R.id.fragment_container);
        setPresenter(mUserPresenter);
    }

    @Override
    protected void resolveDependencies(@NonNull ActivityComponent activityComponent) {
        super.resolveDependencies(activityComponent);
        mUserComponent = activityComponent.userComponent(new UserModule(this));
        mUserComponent.inject(this);
    }

    @Override
    public void loadUserListFragment() {
        navigateTo(UserListFragment.newInstance());
    }
}
