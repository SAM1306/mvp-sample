package st.avinasha.refmvp.ui.base;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

public interface FragmentListener {

    void navigateTo(@NonNull Fragment fragment);

    void navigateTo(Class<? extends ActivityCompat> activityClass);
}
