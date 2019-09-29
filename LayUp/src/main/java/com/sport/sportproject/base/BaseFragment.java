package com.sport.sportproject.base;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.sport.sportproject.R;
import com.sport.sportproject.utils.LoadingDialog;
import butterknife.ButterKnife;
import butterknife.Unbinder;
public abstract class BaseFragment<P extends BasePresenter, M> extends Fragment implements PublicView {
    
    public LoadingDialog loadingDialog;
    public Animation animation;
    protected P mPresenter;
    protected M mModel;
    private Unbinder bind;
    private boolean isvisible;
    private boolean isCreate;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isvisible = isVisibleToUser;
            setVisiable();
        } else {
            isvisible = isVisibleToUser;
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(getFragmentLayoutId(), null);
        bind = ButterKnife.bind(this, inflate);
        initView();
        mModel = initModel();
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this, (PublicModel) mModel);
            Loadding();
        }
        initData();
        initListener();
        isCreate = true;
        return inflate;
    }

    protected void initListener() {

    }

    protected void initData() {

    }

    protected void initView() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
        setVisiable();
        mPresenter = null;
    }

    private void Loadding() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(getContext(), R.style.CustomDialog);
        }
        animation = AnimationUtils.loadAnimation(BaseApp.getInstance(), R.anim.zuqiu_bg);
    }
    private void setVisiable() {
        if (isvisible && isCreate) {
            isvisible = false;
            isCreate = false;
        }
    }

    protected abstract M initModel();

    protected abstract P initPresenter();

    protected abstract int getFragmentLayoutId();
}
