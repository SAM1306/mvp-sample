package st.avinasha.refmvp.mvp.state;

import android.os.Bundle;
import android.support.annotation.NonNull;

import icepick.Icepick;

/**
 * A {@link SavedStateHandler} that uses {@link Icepick} to manage the state.
 */
public class IcepickSavedStateHandler implements SavedStateHandler {

    @Override
    public void restoreInstanceState(@NonNull Object target, @NonNull Bundle state) {
        Icepick.restoreInstanceState(target, state);
    }

    @Override
    public void saveInstanceState(@NonNull Object target, @NonNull Bundle state) {
        Icepick.saveInstanceState(target, state);
    }

}
