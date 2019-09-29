package com.sport.sportproject.ui.main_navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseActivity;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.ui.activity_login.LoginActivity;
import com.sport.sportproject.ui.activity_main.MainActivity;
import com.sport.sportproject.utils.DataCleanManager;
import com.sport.sportproject.utils.GetVersionUtils;
import com.sport.sportproject.utils.StatusBarUtil;
import com.sport.sportproject.utils.ToastUtil;
import com.sport.sportproject.utils.VersionCode;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.tv_toolbar)
    TextView mTvToolbar;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_versions)
    TextView mTvVersions;
    @BindView(R.id.cb_receive_push_message)
    CheckBox mCbReceivePushMessage;

    @BindView(R.id.tv_night_no)
    TextView mTvNightNo;

    @BindView(R.id.ll_login_after)
    LinearLayout mLlLoginAfter;

    @BindView(R.id.tv_cache_size)
    TextView mTvCacheSize;

    @BindView(R.id.rl_clear_cache)
    RelativeLayout mRlClearCache;

    private boolean isClick = true;
    private String totalCacheSize;

    @Override
    protected void initListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Finish();
            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        StatusBarUtil.setStatusBarColor(this, R.color.c_e34536);
        initTitle();
        getVersionsCode();
        getCacheSize();
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_setting;
    }
    // 获取缓存大小
    private void getCacheSize() {
        try {
            totalCacheSize = DataCleanManager.getTotalCacheSize(BaseApp.getInstance());
            mTvCacheSize.setText(totalCacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void Finish() {
        finish();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }

    // 获取版本号
    @SuppressLint("SetTextI18n")
    private void getVersionsCode() {                                        //Float.parseFloat(VersionCode.getAppVersionCode(BaseApp.getInstance())
        mTvVersions.setText(getResources().getString(R.string.versions) + Float.parseFloat(VersionCode.getAppVersionCode(BaseApp.getInstance()) + getResources().getString(R.string.nulls)));
    }
    private void initTitle() {
        mTvToolbar.setText(R.string.setting);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.def_btn_while);
    }

    @Override
    public void onSuccess(int type, Object[] objects) {

    }
    @Override
    public void onFaile(Throwable e) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Finish();
    }


    @OnClick({R.id.cb_receive_push_message, R.id.rl_clear_cache,R.id.back_login})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.cb_receive_push_message:
                if (isClick) {
                    mLlLoginAfter.setVisibility(View.VISIBLE);
                    mCbReceivePushMessage.setBackgroundResource(R.drawable.red_select_frame);
                    isClick = false;
                } else {
                    mLlLoginAfter.setVisibility(View.GONE);
                    mCbReceivePushMessage.setBackgroundResource(R.drawable.red_unselect_frame);
                    isClick = true;
                }
                break;
            case R.id.rl_clear_cache:
                DataCleanManager.clearAllCache(BaseApp.getInstance());
                getCacheSize();
                ToastUtil.showShort("清除完成");
                break;
            case R.id.back_login://退出登录，需要清除本地保存的用户信息
//                退出登录
                SharedPreferences sp = this.getSharedPreferences("headler_img", Context.MODE_PRIVATE);//清除头像
                sp.edit().clear().commit();//清除数据必须要提交:提交以后，文件仍存在，只是文件中的数据被清除了
                //2、将本地保存的图片的file删除
                File filesDir;
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {//判断sd卡是否挂载
                    //路径1：storage/sdcard/Android/data/包名/files
                    filesDir = this.getExternalFilesDir("");
                } else {//手机内部存储
                    //路径：data/data/包名/files
                    filesDir = this.getFilesDir();
                }
                File file = new File(filesDir, "icon.png");
                if (file.exists()){
                    file.delete();//删除存储中的文件
                }
//                3、销毁所有的Activity
//                this.removeAll();
//                4、重新进入首页面
//                goToActivity(MainActivity.class,null);
                this.finish();
                startActivity(new Intent(this,LoginActivity.class));
//                break;
        }
    }
}
