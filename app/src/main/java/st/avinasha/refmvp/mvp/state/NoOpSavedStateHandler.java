package st.avinasha.refmvp.mvp.state;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
/**
 * A {@link SavedStateHandler} that does nothing. This may be useful for testing purposes.
 */
public class NoOpSavedStateHandler implements SavedStateHandler {

    @Override
    public void restoreInstanceState(@NonNull Object target,
                                     @Nullable Bundle state) {
        // no-op
    }

    @Override
    public void saveInstanceState(@NonNull Object target,
                                  @NonNull Bundle state) {
        // no-op
    }

}
