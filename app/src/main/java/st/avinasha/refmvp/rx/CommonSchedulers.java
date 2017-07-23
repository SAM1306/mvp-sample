package st.avinasha.refmvp.rx;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.ObservableTransformer;

@Singleton
public final class CommonSchedulers {

    private AndroidIoSchedulerTransform<Object> ANDROID_IO_SCHEDULER_TRANSFORM
            = new AndroidIoSchedulerTransform<>();

    @Inject
    CommonSchedulers() {}

    public <T> ObservableTransformer<T, T> getIoToMainScheduler() {
        return (ObservableTransformer<T, T>) ANDROID_IO_SCHEDULER_TRANSFORM;
    }
}
