package com.cumulus.xts.paydemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Response.ErrorListener, Response.Listener<String> {

    private String mUrl = "http://api.banmi.com/api/app/v3/payments/alipay";
    private String mToken = "mQzcEwW2B5eSdjiqSb8pUZ3ESDiXT4ArER2Ldt6sGmLhWNLv4R8vO7umIuM6tdwaAhVeQjSqwMRCbMYqUTySbl1UM6sAb4y0sdMT9MxIwgcGyz5yAmsw93Ub7i5p9wJZVscFw";
    /**
     * 阿里支付
     */
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                pay();
                break;
        }
    }

    private void pay() {
        //1.请求公司服务器,把商品信息传递过去()
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(StringRequest.Method.POST, mUrl,
                this, this){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                ArrayMap<String, String> map = new ArrayMap<>();
                //金额
                map.put("amount","1");
                map.put("token",mToken);
                map.put("version","3.1.3");
                map.put("os","android");

                return map;
            }
        };
        queue.add(request);



    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {

    }

    @Override
    public void onResponse(String s) {
        //2.解析数据
        Gson gson = new Gson();
        Bean bean = gson.fromJson(s, Bean.class);
        //3.调用三方的sdk
        callSDK(bean);
    }

    private void callSDK(Bean bean) {
        final String orderInfo = bean.getResult().getSign();   // 订单信息

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(MainActivity.this);
                Map<String, String> map = alipay.payV2(orderInfo, true);

                Message msg = new Message();
                msg.obj = map;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        //4.支付结果处理
        public void handleMessage(Message msg) {
            PayResult result = new PayResult((Map<String, String>) msg.obj);
            String status = result.getResultStatus();//状态码
            if (TextUtils.equals(status,"9000")){
               showToast("支付成功");
            }else if (TextUtils.equals(status,"6001")){
                showToast("用户取消");
            }else {
                showToast("支付失败");
            }
        };
    };

    public void showToast(String msg){
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }


}
