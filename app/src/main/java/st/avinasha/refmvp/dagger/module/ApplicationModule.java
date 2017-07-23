package st.avinasha.refmvp.dagger.module;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public final class ApplicationModule {

    private static Context sContext;

    public ApplicationModule(@NonNull Context context) { sContext = context;
    }

    @Provides
    @Singleton
    public static Context provideContext() {
        return sContext;
    }

    @Provides
    @Singleton
    public static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
