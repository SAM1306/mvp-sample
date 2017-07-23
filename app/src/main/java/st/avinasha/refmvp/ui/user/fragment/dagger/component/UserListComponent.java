package st.avinasha.refmvp.ui.user.fragment.dagger.component;

import dagger.Subcomponent;
import st.avinasha.refmvp.dagger.annotation.PerFragment;
import st.avinasha.refmvp.ui.user.fragment.UserListFragment;
import st.avinasha.refmvp.ui.user.fragment.dagger.module.UserListModule;

@Subcomponent(modules = UserListModule.class)
@PerFragment
public interface UserListComponent {

    void inject(UserListFragment userListFragment);
}
