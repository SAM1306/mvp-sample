package st.avinasha.refmvp.mvp;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * Adds additional Fragment lifecycle methods not shared with Activities to {@link
 * BaseLifecyclePresenter}. All presenters hosted in a Fragment should be derived from this class.
 *
 * @see BaseLifecyclePresenter
 */
public class BaseFragmentPresenter extends BaseLifecyclePresenter {

    private boolean hasView;

    public boolean hasView() {
        return hasView;
    }

    @CallSuper
    public void onCreateOptionsMenu(@NonNull Menu menu,
                                    @NonNull MenuInflater inflater) {
        // no-op
    }

    @CallSuper
    public void onDestroyView() {
        hasView = false;
    }

    @CallSuper
    public void onViewCreated() {
        hasView = true;
    }

    /**
     * @return true if the presenter is in a state where Fragment transactions are allowed (i.e. due
     * not result in crashes due to state loss checking), false otherwise.
     */
    public boolean isFragmentTransactionAllowed() {
        return hasView && !onSaveInstanceStateCalled();
    }

}