package st.avinasha.refmvp;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import st.avinasha.refmvp.dagger.component.ApplicationComponent;
import st.avinasha.refmvp.dagger.component.DaggerApplicationComponent;
import st.avinasha.refmvp.dagger.module.ApplicationModule;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                                    .applicationModule(new ApplicationModule(this))
                                    .build();
    }

    public static UserApplication get(@NonNull Context context) {
        if (context.getApplicationContext() instanceof UserApplication) {
            Log.d(UserApplication.class.getName(), "UserApplication Instance");
        }
        return (UserApplication) checkNotNull(context).getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
