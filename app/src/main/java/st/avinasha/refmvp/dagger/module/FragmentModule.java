package st.avinasha.refmvp.dagger.module;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.HashSet;
import java.util.Set;

import butterknife.Unbinder;
import dagger.Module;
import dagger.Provides;
import st.avinasha.refmvp.dagger.annotation.BinderSet;
import st.avinasha.refmvp.dagger.annotation.PerBaseFragment;
import st.avinasha.refmvp.ui.base.BaseFragment;

@Module
public final class FragmentModule {

    private static BaseFragment sBaseFragment;

    public FragmentModule(@NonNull BaseFragment baseFragment) {
        sBaseFragment = baseFragment;
    }

    @Provides
    @PerBaseFragment
    @BinderSet
    public static Set<Unbinder> provideUnbinder() {
        return new HashSet<>();
    }

    @Provides
    @PerBaseFragment
    public static RecyclerView.LayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(sBaseFragment.getContext());
    }
}
