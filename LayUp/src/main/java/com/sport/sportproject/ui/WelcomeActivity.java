package com.sport.sportproject.ui;

import android.content.Intent;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseActivity;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.ui.activity_attention_team.Main3Activity;
import com.sport.sportproject.ui.activity_main.MainActivity;
import com.sport.sportproject.utils.SharedPreferencesUtils;

import butterknife.BindView;

public class WelcomeActivity extends BaseActivity {

    private static final String FIRSI = "first";

    @BindView(R.id.iv_shpash_bg)
    ImageView mIvShpashBg;
    @BindView(R.id.iv_splash_activity_logo)
    ImageView mIvSplashActivityLogo;

    private Animation animation;
    private boolean b;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (b) b = false;
        animation = null;
    }

    /**
     * 初始化监听事件, 处理事件的监听逻辑
     */
    @Override
    protected void initListener() {

    }
    /**
     * 初始化数据,一般进行网络请求
     */
    @Override
    protected void initData() {
    }
    /**
     * 初始化视图
     */

    @Override
    protected void initView() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        animation = new AnimationUtils().loadAnimation(BaseApp.getInstance(), R.anim.splash_bg);
        animation.setFillAfter(true);
        mIvSplashActivityLogo.setImageResource(R.mipmap.splash_activity_logo);
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                String not = (String) SharedPreferencesUtils.getParam(FIRSI, "not");
                if (not.equals("not")) {
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                }
                finish();
                overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        b = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mIvShpashBg.setImageResource(R.drawable.splash_bg);
                mIvShpashBg.startAnimation(animation);
            }
        }, 1000);
    }
    /**
     * @return 获取布局
     */
    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_welcome;
    }
    /**
     * @param type    区分
     * @param objects
     */
    @Override
    public void onSuccess(int type, Object[] objects) {
    }
    /**
     * 请求错误
     *
     * @param e
     */
    @Override
    public void onFaile(Throwable e) {

    }


}
