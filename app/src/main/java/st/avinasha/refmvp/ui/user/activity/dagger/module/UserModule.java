package st.avinasha.refmvp.ui.user.activity.dagger.module;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import st.avinasha.refmvp.dagger.annotation.PerActivity;
import st.avinasha.refmvp.ui.user.activity.UserActivity;
import st.avinasha.refmvp.ui.user.activity.presentation.UserPresentation;

@Module
public final class UserModule {

    private static UserPresentation sUserPresentation;

    public UserModule(@NonNull UserPresentation userPresentation) {
        sUserPresentation = userPresentation;
    }

    @Provides
    @PerActivity
    public static UserPresentation provideUserPresentation() {
        return sUserPresentation;
    }
}
