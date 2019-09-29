package com.example.logindemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.img_return)
    ImageView mImgReturn;
    @BindView(R.id.phone)
    EditText mPhone;
    @BindView(R.id.import_verification_code)
    EditText mImportVerificationCode;
    @BindView(R.id.verification_code)
    EditText mVerificationCode;
    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.checkbox)
    CheckBox mCheckbox;
    @BindView(R.id.wechat_login)
    ImageView mWechatLogin;
    @BindView(R.id.qq_login)
    ImageView mQqLogin;
    @BindView(R.id.xinlang_login)
    ImageView mXinlangLogin;
    private Activity activity =  new Activity();

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        
        return activity.dispatchTouchEvent(ev);
    }

    /**
     * 第一通航登录Demo
     * @param savedInstanceState 苏克阳  2019、7、3
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    
    @OnClick({R.id.img_return, R.id.import_verification_code, R.id.btn, R.id.checkbox, R.id.wechat_login, R.id.qq_login, R.id.xinlang_login})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img_return:
                break;
            case R.id.import_verification_code:
                break;
            case R.id.btn:
                break;
            case R.id.checkbox:
                break;
            case R.id.wechat_login:
                break;
            case R.id.qq_login:
                break;
            case R.id.xinlang_login:
                break;
        }
    }
}