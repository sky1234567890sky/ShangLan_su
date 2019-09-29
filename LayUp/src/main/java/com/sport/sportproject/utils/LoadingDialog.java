package com.sport.sportproject.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.sport.sportproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context);
    }

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
    }

    private void init(Context context) {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.loading);//loading的xml文件
        ImageView mIv = findViewById(R.id.iv);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.zhuan);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        animation.setInterpolator(linearInterpolator);
        mIv.startAnimation(animation);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        show();
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismiss();
    }
    @Override
    public void show() {//开启
        super.show();
    }
    @Override
    public void dismiss() {//关闭
        super.dismiss();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }

    class ViewHolder {
        @BindView(R.id.iv)
        ImageView mIv;
        @BindView(R.id.tv_load_dialog)
        TextView mTvLoadDialog;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}