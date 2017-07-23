package st.avinasha.refmvp.dagger.module;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import st.avinasha.refmvp.dagger.annotation.PerBaseActivity;
import st.avinasha.refmvp.ui.base.BaseActivity;
import st.avinasha.refmvp.ui.base.FragmentListener;

@Module
public final class ActivityModule {

    private static BaseActivity sActivity;

    public ActivityModule(BaseActivity baseActivity) {
        sActivity = baseActivity;
    }

    @Provides
    @PerBaseActivity
    public static FragmentListener provideFragmentListener() {
        return sActivity;
    }

    @Provides
    @PerBaseActivity
    public static FragmentManager provideFragmentManager() {
        return sActivity.getSupportFragmentManager();
    }
}
