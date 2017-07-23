package st.avinasha.refmvp.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.google.common.base.Optional;

import javax.inject.Inject;

import st.avinasha.refmvp.UserApplication;
import st.avinasha.refmvp.dagger.component.ActivityComponent;
import st.avinasha.refmvp.dagger.module.ActivityModule;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseActivity extends AppCompatActivity implements FragmentListener {

    private ActivityComponent mActivityComponent;

    private Optional<Integer> mFragmentContainerId;

    @Inject FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = UserApplication.get(this)
                                .getApplicationComponent()
                                .activityComponent(new ActivityModule(this));
        resolveDependencies(mActivityComponent);
    }

    @CallSuper
    protected void resolveDependencies(@NonNull ActivityComponent activityComponent) {
        mActivityComponent.inject(this);
    }

    public void setFragmentContainerId(@IdRes int fragmentContainerId) {
        mFragmentContainerId = Optional.of(fragmentContainerId);
    }

    @Override
    public void navigateTo(Class<? extends ActivityCompat> activityClass) {
        throw new RuntimeException("To be implemented by Child class");
    }

    @Override
    public void navigateTo(@NonNull Fragment fragment) {
        if (!mFragmentContainerId.isPresent()) {
            throw new IllegalStateException("setFragmentContainerId should be called first !");
        }
        mFragmentManager.beginTransaction()
                .replace(mFragmentContainerId.get(), fragment)
                .commit();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    public static BaseActivity get(@NonNull Activity activity) {
        return ((BaseActivity) checkNotNull(activity));
    }
}
