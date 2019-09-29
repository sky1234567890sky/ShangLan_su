package com.sport.sportproject.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sport.sportproject.R;
import com.sport.sportproject.utils.ToastUtil;

import static com.sport.sportproject.R.id.btn1;

public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 执行UI操作
            switch (msg.what) {
                case 1:
                    int in = (int) msg.obj;
                    ToastUtil.showShort(in);
                    break;
                    case 2:
                        int in_ = (int) msg.obj;
                        ToastUtil.showShort(in_);
                        break;
            }
        }
    };
    private Button mBtn1;
    private Button mBtn2;
    private View mBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        mBtn1 = findViewById(btn1);
        mBtn2 = findViewById(R.id.btn2);
        mBtn3 = findViewById(R.id.btn3);
        initView();

    }

    private void initView() {
        mBtn1();
        mBtn2();
        mBtn3();
    }

    private void mBtn3() {
        mBtn3.setOnClickListener(this);

    }

    private void mBtn2() {
        mBtn2.setOnClickListener(this);
    }

    private void mBtn1() {
        mBtn1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn1){
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    //模拟耗时操作
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message message = handler.obtainMessage();
                    message.what = 2;//标识
                    message.obj = 2; // 消息内容存放
                    handler.sendMessage(message);//：在工作线程中 通过Handler发送消息到消息队列中
                }
            };

        }else if (v.getId()==R.id.btn3){
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message message = handler.obtainMessage();
                    message.what = 1;//标识
                    message.obj = 1; // 消息内容存放
                    handler.sendMessage(message);//：在工作线程中 通过Handler发送消息到消息队列中

                }
            };
                   }else if (v.getId()==R.id.btn3){

            new Thread(){
                @Override
                public void run() {
                    super.run();


                }
            };
        }

    }
}
