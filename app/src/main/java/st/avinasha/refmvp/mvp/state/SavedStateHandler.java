package st.avinasha.refmvp.mvp.state;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Manges the state saving and restoration of the state of the given object into the given {@link
 * Bundle}.
 */
public interface SavedStateHandler {

    void restoreInstanceState(@NonNull Object target,
                              @Nullable Bundle state);

    void saveInstanceState(@NonNull Object target,
                           @NonNull Bundle state);

}
