package com.sport.sportproject.ui.main_navigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.sport.sportproject.R;
import com.sport.sportproject.utils.NetworkUtils;
import com.sport.sportproject.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 只在wifi环境下使用联网
 */
public class HuanWangActivity extends AppCompatActivity {

    @BindView(R.id.btn_last)
    ImageView mBtnLast;
    @BindView(R.id.checked)
    Switch mChecked;
    private boolean wiFiConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huan_wang);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        wiFiConnect = NetworkUtils.isWiFiConnect(this);
//        boolean networkConnected = NetworkUtils.isNetworkConnected(this);
        //换网处理
        mChecked.setChecked(wiFiConnect);
        mChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wiFiConnect = isChecked;
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
//        SharedPreferencesUtils.setParam(this,);
    }

    @OnClick({R.id.btn_last})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_last:
                finish();
                break;
        }
    }
}
