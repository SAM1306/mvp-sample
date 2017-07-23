package st.avinasha.refmvp.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * Adds additional Activity lifecycle methods not shared with Fragments to {@link
 * BaseLifecyclePresenter}. All presenters hosted in an Activity should be derived from this class.
 *
 * @see BaseLifecyclePresenter
 */
public class BaseActivityPresenter extends BaseLifecyclePresenter {

    @CallSuper
    public boolean onCreateOptionsMenu(@NonNull Menu menu,
                                       @NonNull MenuInflater menuInflater) {
        return false;
    }

}