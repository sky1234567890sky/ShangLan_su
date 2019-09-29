package com.sport.sportproject.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sport.sportproject.JSCallback.JSCallback;
import com.sport.sportproject.JSCallback.PopVp;
import com.sport.sportproject.JSCallback.PopWebViewPager;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseMvpActivity;
import com.sport.sportproject.base.BasePresenter;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.utils.StatusBarUtil;
import com.sport.sportproject.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends BaseMvpActivity {

    private static final String PARAMS = "params";
    private static final String COMMENTS = "comments";
    private static final String AID = "aid";

    @BindView(R.id.tv_num_comments)
    TextView mTvNumComments;
    @BindView(R.id.web)
    WebView mWeb;
    @BindView(R.id.et_write_comments)
    EditText mEtWriteComments;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_comments)
    ImageView mIvComments;
    @BindView(R.id.tv_comments_num)
    TextView mTvCommentsNum;
    @BindView(R.id.ll_bottom)
    LinearLayout mLlBottom;

    @BindView(R.id.web_ll)
    LinearLayout web_ll;

    private int comments;
    private boolean isBottomShow = true;
    private String mAid;

    private String[] imageUrls;
    //    public static void go2Acitvity(Context context, String url, int comments) {
//        Intent intent = new Intent(context, WebViewActivity.class);
//        intent.putExtra(PARAMS, url);
//        intent.putExtra(COMMENTS, comments);
//        context.startActivity(intent);
//    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    public static void go2Acitvity(Context context, String aid, int comments) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(AID, aid);
        intent.putExtra(COMMENTS, comments);
        context.startActivity(intent);
    }

    @Override
    protected Object initModel() {
        return null;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @SuppressLint("NewApi")
    @Override
    protected void initListener() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Finish();
            }
        });

        mWeb.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY - oldScrollY > 0 && isBottomShow) {  //下移隐藏
                    isBottomShow = false;
                    mLlBottom.animate().translationY(mLlBottom.getHeight());
                } else if (scrollY - oldScrollY < 0 && !isBottomShow) {    //上移出现
                    isBottomShow = true;
                    mLlBottom.animate().translationY(0);
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    //携带值的方法
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getData(PopVp popVp) {
        final int index = popVp.getIndex();
        final List<String> strings = popVp.getmImageList();
        Log.i("值：", "getData: " + index + strings.toString());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                initPopupWindow(strings, index);
            }
        });
    }



    //弹窗
    private void initPopupWindow(final List<String> list, final int index) {
//                ToastUtil.showShort("弹");
        final View view = View.inflate(WebViewActivity.this, R.layout.viewpage_item_imageview, null);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        RelativeLayout rlt = view.findViewById(R.id.rlt);
        //点击弹窗外部  弹窗消失    背景
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(mToolbar);

        final ViewPager vp = view.findViewById(R.id.img_vp);
        ImageView return_web = view.findViewById(R.id.return_webview);
        TextView mLastImg = view.findViewById(R.id.last_img);
        TextView mSaveImg = view.findViewById(R.id.save_img);
        TextView mEnterImg = view.findViewById(R.id.enter_img);

        mLastImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        PopWebViewPager adapter = new PopWebViewPager(list);
        vp.setAdapter(adapter);
    }

    //webview设置
    @SuppressLint({"JavascriptInterface", "NewApi", "SetTextI18n", "SetJavaScriptEnabled"})
    @Override
    protected void initView() {
        getto();
        initTitle();
        mTvNumComments.setText(comments+"评论");
        mTvCommentsNum.setText(comments+"");
        //辅助WebView处理JavaScript的对话框，网站图标，网站title，加载进度等
        mWeb.setWebChromeClient(new MyWebChromeClient());
        mWeb.setWebViewClient(new MyWebViewClient());
        mWeb.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);// 去掉底部和右边的滚动条
        WebSettings webSettings = mWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDomStorageEnabled(true);//允许本地DOM存储
        webSettings.setAllowFileAccess(true);//允许访问文件
        webSettings.setAppCacheEnabled(true);//允许缓存本地
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//设置缓存模式
        webSettings.setGeolocationEnabled(true);//允许定位
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setTextZoom(100);//设置页面上的文本缩放百分比，默认100。
        webSettings.setBuiltInZoomControls(false);// 设置是否支持缩放
        webSettings.setSupportZoom(false);// 设置是否支持变焦,仅支持双击缩放
        webSettings.setDefaultFontSize(14);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //在js中调用本地java方法
        mWeb.addJavascriptInterface(new JSCallback(), "Android");
//        Android 5.0上Webview默认不允许加载Http与Https混合内容
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWeb.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        if (mAid != null) {
            mWeb.loadUrl("https://bkbapi.dqdgame.com/article/" + mAid + ".html");
        }
    }

    //TODO:webView界面
    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_web_view;
    }
    private void initTitle() {
        StatusBarUtil.setStatusBarColor(this, R.color.c_e34536);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    private void getto() {
        if (getIntent() != null) {
//            url = getIntent().getStringExtra(PARAMS);
            comments = getIntent().getIntExtra(COMMENTS, 0);
            mAid = getIntent().getStringExtra(AID);
            Log.i("tag", "getto: " + comments + "-------" + mAid);
        }
    }

    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:

                break;
        }
    }

    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showShort(e.getMessage());
    }

    @OnClick(R.id.iv_comments)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_comments:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Finish();
    }

    private void Finish() {
        finish();
        mWeb.goBack();
    }

    @Override
    protected void onDestroy() {
        mWeb.loadUrl("about:blank");
        mWeb.removeAllViews();
        mWeb.destroy();
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            ToastUtil.showShort("onProgressChanged:" + newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            ToastUtil.showShort("onReceivedTitle:" + title);
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            ToastUtil.showShort("onJsAlert");
            return super.onJsAlert(view, url, message, result);
        }

        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
            ToastUtil.showShort("onReceivedIcon:" + icon.toString());
        }

        @Override
        public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
            super.onReceivedTouchIconUrl(view, url, precomposed);
            ToastUtil.showShort("onReceivedTouchIconUrl:" + url);
        }

        @Override
        public boolean onJsTimeout() {
            ToastUtil.showShort("加载超时");
            return super.onJsTimeout();
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
            super.onGeolocationPermissionsShowPrompt(origin, callback);
        }

        @Override
        public void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Uri url = request.getUrl();
            }
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

//    static class ViewHolder {
//
//        RelativeLayout mRlt;
//
//        ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
//    }

//    public class MyWebViewClient extends WebViewClient {
//        @Override
//        public void onPageFinished(WebView view, String url) {
//            view.getSettings().setJavaScriptEnabled(true);
//            super.onPageFinished(view, url);
//            addImageClickListener(view);//待网页加载完全后设置图片点击的监听方法
//        }
//
//        @Override
//        public void onPageStarted(WebView view, String url, Bitmap favicon) {
//            view.getSettings().setJavaScriptEnabled(true);
//            super.onPageStarted(view, url, favicon);
//
//        }
//    }
//    private void addImageClickListener(WebView view) {
//        view.loadUrl("javascript:(function(){" +
//                "var objs = document.getElementsByTagName(\"img\"); " +
//
//                "for(var i=0;i<objs.length;i++) " +
//                "{"
//
//                + " objs[i].onclick=function() " +
//
//                " { "
//
//                + " window.imagelistener.openImage(this.src); " +//通过js代码找到标签为img的代码块，设置点击的监听方法与本地的openImage方法进行连接
//                " } " +
//
//                "}" +
//                "})()");
//    }
}
