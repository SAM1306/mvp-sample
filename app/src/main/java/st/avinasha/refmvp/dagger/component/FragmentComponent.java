package st.avinasha.refmvp.dagger.component;

import dagger.Subcomponent;
import st.avinasha.refmvp.dagger.annotation.PerBaseFragment;
import st.avinasha.refmvp.dagger.module.FragmentModule;
import st.avinasha.refmvp.ui.base.BaseFragment;
import st.avinasha.refmvp.ui.user.fragment.dagger.component.UserListComponent;
import st.avinasha.refmvp.ui.user.fragment.dagger.module.UserListModule;

@Subcomponent(modules = FragmentModule.class)
@PerBaseFragment
public interface FragmentComponent {

    // Child components.
    UserListComponent userListComponent(UserListModule userListModule);

    // Injection targets.
    void inject(BaseFragment baseFragment);
}
