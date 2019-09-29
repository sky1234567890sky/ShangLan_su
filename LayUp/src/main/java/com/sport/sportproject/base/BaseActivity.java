package com.sport.sportproject.base;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import com.sport.sportproject.R;
import com.sport.sportproject.utils.LoadingDialogWithContent;
import com.sport.sportproject.utils.NetBroadcastReceiver;
import com.sport.sportproject.utils.ToastUtil;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/**
 * 苏克阳 实训进阶
 */
public abstract class BaseActivity extends AppCompatActivity implements PublicView {

    private Unbinder bind;

    private NetBroadcastReceiver netWorkChangReceiver;

    public  BaseApp mApplication;

    private LoadingDialogWithContent mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ToastUtil.showShort("我就是一个类："+this.getClass().getSimpleName());
        //一个雷
        mApplication = (BaseApp) getApplication();

        mDialog = new LoadingDialogWithContent(this, getString(R.string.loading));

        setContentView(getActivityLayoutId());

        bind = ButterKnife.bind(this);
        RequestPermissions();
        initMvp();
        initView();
        initData();
        initListener();
        MonitorNetWorkChange();
    }
    public void showLoadingDialog() {
        if (!mDialog.isShowing()) mDialog.show();
    }
    public void hideLoadingDialog() {

        if (mDialog.isShowing()) mDialog.dismiss();
    }
    protected void initMvp() {
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkChangReceiver);
        bind.unbind();
    }
    private void RequestPermissions() {
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.WRITE_APN_SETTINGS,
                    Manifest.permission.READ_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }
    /**
     * 在Android 7.0之静态注册广播的方式被取消了，所以这里采用动态注册的方式
     * 注册网络状态监听广播
     */
    private void MonitorNetWorkChange() {
        netWorkChangReceiver = new NetBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netWorkChangReceiver, filter);
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getActivityLayoutId();


}
