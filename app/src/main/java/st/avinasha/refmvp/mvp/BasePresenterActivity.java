package st.avinasha.refmvp.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import st.avinasha.refmvp.mvp.state.IcepickSavedStateHandler;
import st.avinasha.refmvp.ui.base.BaseActivity;

/**
 * Exposes a {@link #setPresenter(BaseActivityPresenter)} method that allows the lifecycle methods
 * of the {@link BaseActivityPresenter} to be automatically called at the appropriate times.
 */
public class BasePresenterActivity extends BaseActivity {

    private BaseActivityPresenter presenter;
    private Bundle savedStateBundle;
    private List<PresenterLifecycleCallback> presenterLifecycleCallbacks = new ArrayList<>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (isCallbackRequested(PresenterLifecycleCallback.ON_ACTIVITY_RESULT)) {
            presenter.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedStateBundle = savedInstanceState;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (isCallbackRequested(PresenterLifecycleCallback.ON_CREATE_OPTION_MENU)) {
            return presenter.onCreateOptionsMenu(
                    menu,
                    getMenuInflater())
                    || super.onCreateOptionsMenu(menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isCallbackRequested(PresenterLifecycleCallback.ON_DESTROY)) {
            presenter.onDestroy();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (isCallbackRequested(PresenterLifecycleCallback.ON_OPTIONS_ITEM_SELECTED)) {
            return presenter.onOptionsItemSelected(item)
                    || super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isCallbackRequested(PresenterLifecycleCallback.ON_PAUSE)) {
            presenter.onPause();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (isCallbackRequested(PresenterLifecycleCallback.ON_REQUEST_PERMISSION_RESULT)) {
            presenter.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isCallbackRequested(PresenterLifecycleCallback.ON_RESUME)) {
            presenter.onResume();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (isCallbackRequested(PresenterLifecycleCallback.ON_SAVE_INSTANCE_STATE)) {
            presenter.onSaveInstanceState(outState);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isCallbackRequested(PresenterLifecycleCallback.ON_START)) {
            presenter.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isCallbackRequested(PresenterLifecycleCallback.ON_STOP)) {
            presenter.onStop();
        }
    }

    private boolean isCallbackRequested(@NonNull PresenterLifecycleCallback callback) {
        return presenter != null && presenterLifecycleCallbacks.contains(callback);
    }

    /**
     * Sets the presenter and calls the complete list of callback methods.
     *
     * @see #setPresenter(BaseActivityPresenter, PresenterLifecycleCallback[])
     */
    protected void setPresenter(@NonNull BaseActivityPresenter presenter) {
        setPresenter(presenter, PresenterLifecycleCallback.getDefaults());
    }

    /**
     * Sets the presenter in order to call the given list of {@link PresenterLifecycleCallback}
     * methods on the presenter automatically at the appropriate times. Any methods omitted from
     * the full list should be called manually.
     * <p>
     * It is assumed this method will be called in {@link #onCreate(Bundle)} after the super call,
     * and therefore the {@link BaseLifecyclePresenter#onCreate(Bundle)} method will be
     * triggered here automatically. If it is created sooner, that method should be called
     * manually.
     *
     * @param presenter the presenter to set
     * @param callbacks the subset of callbacks to trigger automatically
     */
    protected void setPresenter(@NonNull BaseActivityPresenter presenter,
                                @NonNull PresenterLifecycleCallback[] callbacks) {
        this.presenter = presenter;
        this.presenterLifecycleCallbacks = Arrays.asList(callbacks);
        this.presenter.setSavedStateHandler(new IcepickSavedStateHandler());
        if (isCallbackRequested(PresenterLifecycleCallback.ON_CREATE)) {
            this.presenter.onCreate(savedStateBundle);
        }
    }

    public enum PresenterLifecycleCallback {

        ON_ACTIVITY_RESULT,
        ON_CREATE,
        ON_CREATE_OPTION_MENU,
        ON_OPTIONS_ITEM_SELECTED,
        ON_DESTROY,
        ON_PAUSE,
        ON_REQUEST_PERMISSION_RESULT,
        ON_RESUME,
        ON_SAVE_INSTANCE_STATE,
        ON_START,
        ON_STOP;

        public static PresenterLifecycleCallback[] getDefaults() {
            return values();
        }

        public static PresenterLifecycleCallback[] getDefaultsMinus(
                PresenterLifecycleCallback... omittedCallbacks) {
            List<PresenterLifecycleCallback> defaultList = Arrays.asList(getDefaults());
            List<PresenterLifecycleCallback> omissionList = Arrays.asList(omittedCallbacks);
            defaultList.removeAll(omissionList);
            return (PresenterLifecycleCallback[]) defaultList.toArray();
        }

    }

}
