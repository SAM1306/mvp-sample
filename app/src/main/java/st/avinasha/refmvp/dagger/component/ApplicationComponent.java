package st.avinasha.refmvp.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import st.avinasha.refmvp.dagger.module.ActivityModule;
import st.avinasha.refmvp.dagger.module.ApplicationModule;
import st.avinasha.refmvp.net.dagger.NetModule;

@Component(modules = {
        ApplicationModule.class,
        NetModule.class
})
@Singleton
public interface ApplicationComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);
}
