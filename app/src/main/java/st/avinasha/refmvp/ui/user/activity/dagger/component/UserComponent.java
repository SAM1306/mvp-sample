package st.avinasha.refmvp.ui.user.activity.dagger.component;

import dagger.Subcomponent;
import st.avinasha.refmvp.dagger.annotation.PerActivity;
import st.avinasha.refmvp.ui.user.activity.UserActivity;
import st.avinasha.refmvp.ui.user.activity.dagger.module.UserModule;

@Subcomponent(modules = UserModule.class)
@PerActivity
public interface UserComponent {

    // Injection targets
    void inject(UserActivity userActivity);
}
