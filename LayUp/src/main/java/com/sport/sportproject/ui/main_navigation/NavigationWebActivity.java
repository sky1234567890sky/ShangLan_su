package com.sport.sportproject.ui.main_navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseActivity;
import com.sport.sportproject.utils.StatusBarUtil;

import butterknife.BindView;

public class NavigationWebActivity extends BaseActivity {

    private static final String URL = "url";
    @BindView(R.id.tv_toolbar)
    TextView mTvToolbar;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.web)
    WebView mWeb;
    @BindView(R.id.progress)
    ProgressBar mProgress;

    public static void go2Activtiy(Context context, String url) {
        context.startActivity(new Intent(context, NavigationWebActivity.class).putExtra(URL, url));
    }

    @Override
    public void onSuccess(int type, Object[] objects) {

    }

    @Override
    public void onFaile(Throwable e) {

    }


    @Override
    protected void initListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void initView() {

        StatusBarUtil.setStatusBarColor(NavigationWebActivity.this, R.color.c_e34536);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.def_btn_while);
        if (getIntent() != null) ;
        String murl = getIntent().getStringExtra(URL);
        mWeb.getSettings().setJavaScriptEnabled(true);
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.getSettings().setUseWideViewPort(true);
        mWeb.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWeb.getSettings().setLoadWithOverviewMode(true);
        mWeb.getSettings().setLoadsImagesAutomatically(true);
        mWeb.loadUrl(murl);
        setSettingWebChromeClient(mWeb);
        /**
         * Android的webview在使用h5页面的时候，容易碰到h5页面中的图片加载异常的问题。
         * 一般情况下这种情况是由于android端和h5页面端使用的http链接头不一致导致的。
         * Android中使用了https头，而h5页面中使用了http头，就会出现此类问题。
         * 反之，亦然。所以在使用webview的时候，一定要保持两者的请求头一致。这样能避免产生很多问题。
         * 此外。在5.0以上的版本中可以设置混合模式来解决这个问题。代码如下:
         * */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWeb.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        // 监听 所有点击的链接，如果拦截到我们需要的，就跳转到相对应的页面。
        mWeb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null && url.contains("url")) {
                    String substring = url.substring(15, url.length());
//                    Intent intent = new Intent(NavigationWebActivity.this, NavigationWebActivity.class);
//                    intent.putExtra(URL, substring);
//                    startActivity(intent);
                    view.loadUrl(substring);
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                view.getSettings().setJavaScriptEnabled(true);
                super.onPageFinished(view, url);
            }
//            webView默认是不处理https请求的，页面显示空白，需要进行如下设置：
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();    //表示等待证书响应
                // handler.cancel();           //表示挂起连接，为默认方式
//                 handler.handleMessage(null);    //可做其他处理
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWeb.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);}
    }
    private void setSettingWebChromeClient(WebView webView) {
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mProgress.setVisibility(View.GONE);
                } else {
                    mProgress.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                if (null != mTvToolbar) mTvToolbar.setText(title);
            }
        });
    }

    @Override
    protected int getActivityLayoutId() {

        return R.layout.activity_navigation_web;

    }

    // 覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWeb.canGoBack()) {
            mWeb.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
//    在 Activity 销毁（ WebView ）的时候，先让 WebView 加载null内容，然后移除 WebView，再销毁 WebView，最后置空。
    @Override
    protected void onDestroy() {
        if (mWeb != null) {
            mWeb.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWeb.clearHistory();
            ((ViewGroup) mWeb.getParent()).removeView(mWeb);
            mWeb.destroy();
            mWeb = null;
        }
        super.onDestroy();
    }



}
