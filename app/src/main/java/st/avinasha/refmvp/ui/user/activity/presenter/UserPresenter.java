package st.avinasha.refmvp.ui.user.activity.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import st.avinasha.refmvp.dagger.annotation.PerActivity;
import st.avinasha.refmvp.mvp.BaseActivityPresenter;
import st.avinasha.refmvp.ui.user.activity.presentation.UserPresentation;

@PerActivity
public class UserPresenter extends BaseActivityPresenter {

    private final UserPresentation mUserPresentation;

    @Inject
    UserPresenter(@NonNull UserPresentation userPresentation) {
        mUserPresentation = userPresentation;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserPresentation.loadUserListFragment();
    }
}
