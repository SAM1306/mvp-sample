package st.avinasha.refmvp.ui.user.fragment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import st.avinasha.refmvp.R;
import st.avinasha.refmvp.dagger.annotation.PerFragment;
import st.avinasha.refmvp.net.model.user.User;

@PerFragment
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<User> mUserList;

    @Inject
    UserListAdapter() {
    }

    // region Adapter callback methods.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View userView = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(userView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        if (position == RecyclerView.NO_POSITION) {
            return;
        }
        viewHolder.sTxtUserName.setText(mUserList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mUserList == null || mUserList.isEmpty() ? 0 : mUserList.size();
    }
    // endregion Adapter callback methods.

    public void setUserList(@NonNull List<User> userList) {
        mUserList = userList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtUserName) TextView sTxtUserName;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
