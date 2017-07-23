package st.avinasha.refmvp.dagger.component;

import dagger.Subcomponent;
import st.avinasha.refmvp.dagger.annotation.PerBaseActivity;
import st.avinasha.refmvp.dagger.module.ActivityModule;
import st.avinasha.refmvp.dagger.module.FragmentModule;
import st.avinasha.refmvp.ui.base.BaseActivity;
import st.avinasha.refmvp.ui.user.activity.dagger.component.UserComponent;
import st.avinasha.refmvp.ui.user.activity.dagger.module.UserModule;

@Subcomponent(modules = ActivityModule.class)
@PerBaseActivity
public interface ActivityComponent {

    // Child Components.
    UserComponent userComponent(UserModule userModule);
    FragmentComponent fragmentComponent(FragmentModule fragmentModule);

    // Injection targets.
    void inject(BaseActivity baseActivity);
}
