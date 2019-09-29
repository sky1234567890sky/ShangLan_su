package com.sport.sportproject.base;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.sport.sportproject.R;
import com.sport.sportproject.utils.LoadingDialog;
/**
 * 苏克阳 实训进阶
 */
public abstract class BaseMvpActivity<P extends BasePresenter, M> extends BaseActivity implements PublicView {

    protected LoadingDialog loadingDialog;
    protected P mPresenter;
    protected M mModel;
    public FragmentManager manager;
    private Animation animation;

    @Override
    protected void initMvp() {
        super.initMvp();

        manager = getSupportFragmentManager();

        mPresenter = initPresenter();

        mModel = initModel();

        if (mPresenter != null) {
            mPresenter.attachView(this, (PublicModel) mModel);
            Loadding();
        }
    }
    private void Loadding() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(BaseApp.getInstance(), R.style.CustomDialog);
        }
        animation = AnimationUtils.loadAnimation(BaseApp.getInstance(), R.anim.zuqiu_bg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter = null;
    }
    protected abstract M initModel();
    protected abstract P initPresenter();

//    private void RequestPermissions() {
//        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
//            finish();
//            return;
//        }
//        if (Build.VERSION.SDK_INT >= 23) {
//            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                    Manifest.permission.ACCESS_FINE_LOCATION,
//                    Manifest.permission.READ_PHONE_STATE,
//                    Manifest.permission.READ_EXTERNAL_STORAGE};
//            ActivityCompat.requestPermissions(this, mPermissionList, 123);
//        }
//    }
//
    protected abstract int getActivityLayoutId();
}
