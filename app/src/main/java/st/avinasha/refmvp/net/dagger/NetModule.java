package st.avinasha.refmvp.net.dagger;

import android.os.AsyncTask;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class NetModule {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Provides
    @Singleton
    public static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(
                        Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR)))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
