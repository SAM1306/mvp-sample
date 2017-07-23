package st.avinasha.refmvp.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import st.avinasha.refmvp.mvp.state.NoOpSavedStateHandler;
import st.avinasha.refmvp.mvp.state.SavedStateHandler;

/**
 * Represents the common lifecycle callback structure that all Activity / Fragment presenters
 * should adhere to. Care should be taken so that all of the lifecycle methods are called by the
 * host Activity / Fragment.
 *
 * @see BaseActivityPresenter
 * @see BaseFragmentPresenter
 */
public abstract class BaseLifecyclePresenter {

    private boolean isCreated;
    private boolean isResumed;
    private boolean isStarted;
    private boolean onSaveInstanceStateCalled;
    private SavedStateHandler savedStateHandler = new NoOpSavedStateHandler();

    public boolean isCreated() {
        return isCreated;
    }

    public boolean isResumed() {
        return isResumed;
    }

    public boolean isStarted() {
        return isStarted;
    }

    @CallSuper
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // no-op
    }

    @CallSuper
    public void onCreate(@Nullable Bundle savedInstanceState) {
        restoreInstanceState(savedInstanceState);
        isCreated = true;
    }

    @CallSuper
    public void onDestroy() {
        isCreated = false;
    }

    @CallSuper
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @CallSuper
    public void onPause() {
        isResumed = false;
    }

    @CallSuper
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        // no-op
    }

    @CallSuper
    public void onResume() {
        onSaveInstanceStateCalled = false;
        isResumed = true;
    }

    @CallSuper
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        saveInstanceState(savedInstanceState);
        onSaveInstanceStateCalled = true;
    }

    public boolean onSaveInstanceStateCalled() {
        return onSaveInstanceStateCalled;
    }

    @CallSuper
    public void onStart() {
        isStarted = true;
    }

    @CallSuper
    public void onStop() {
        isStarted = false;
    }

    private void restoreInstanceState(@Nullable Bundle bundle) {
        if (savedStateHandler == null) {
            return;
        }
        savedStateHandler.restoreInstanceState(this, bundle);
    }

    private void saveInstanceState(@NonNull Bundle bundle) {
        if (savedStateHandler == null) {
            return;
        }
        savedStateHandler.saveInstanceState(this, bundle);
    }

    public void setSavedStateHandler(@Nullable SavedStateHandler savedStateHandler) {
        this.savedStateHandler = savedStateHandler;
    }

}
