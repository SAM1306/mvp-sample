package st.avinasha.refmvp.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.Set;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import st.avinasha.refmvp.dagger.annotation.BinderSet;
import st.avinasha.refmvp.dagger.component.FragmentComponent;
import st.avinasha.refmvp.dagger.module.FragmentModule;

public abstract class BaseFragment extends Fragment {

    private FragmentComponent mFragmentComponent;

    @Inject @BinderSet Set<Unbinder> mUnbinders;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentComponent = BaseActivity
                                .get(getActivity())
                                .getActivityComponent()
                                .fragmentComponent(new FragmentModule(this));
        resolveDependencies(mFragmentComponent);
    }

    @Override
    public void onDestroyView() {
        for (Unbinder unbinder : mUnbinders) {
            unbinder.unbind();
        }
        mUnbinders.clear();
        super.onDestroyView();
    }

    @CallSuper
    protected void resolveDependencies(FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    protected void bindViews(@NonNull View root) {
        mUnbinders.add(ButterKnife.bind(this, root));
    }
}
