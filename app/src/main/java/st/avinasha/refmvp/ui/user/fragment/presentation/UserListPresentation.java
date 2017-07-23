package st.avinasha.refmvp.ui.user.fragment.presentation;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import java.util.List;

import st.avinasha.refmvp.net.model.user.User;

public interface UserListPresentation {

    void displayError(@StringRes int msgId);

    void hideViews();

    void loadUsers(@NonNull List<User> users);

    void showProgress(boolean show);
}
