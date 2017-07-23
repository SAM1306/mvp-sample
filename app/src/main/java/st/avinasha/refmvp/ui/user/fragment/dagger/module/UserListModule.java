package st.avinasha.refmvp.ui.user.fragment.dagger.module;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import st.avinasha.refmvp.dagger.annotation.PerFragment;
import st.avinasha.refmvp.ui.user.fragment.presentation.UserListPresentation;

@Module
public final class UserListModule {

    private static UserListPresentation sUserListPresentation;

    public UserListModule(@NonNull UserListPresentation userListPresentation) {
        sUserListPresentation = userListPresentation;
    }

    @Provides
    @PerFragment
    public static UserListPresentation provideUserListPresentation() {
        return sUserListPresentation;
    }
}
