package com.sport.sportproject.JSCallback;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.interfaces.NetPort;
import com.sport.sportproject.ui.PhotoBrowserActivity;
import com.sport.sportproject.ui.WebViewActivity;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 华为 on 2019/7/21.
 */

public class JSCallback extends WebViewJsInterface.BaseWebViewJsInterface {

    String tag = "JSCallback";
    List<String> mImageList;

    public JSCallback() {
    }
    @JavascriptInterface
    public void adRedirect(String url) {
        Log.e(tag, "adRedirect:" + url);
//        try {
//            Intent intent = AppSchemeHelper.getInstance().dealScheme(getContext(), URLDecoder.decode(url, "utf-8"));
//            startActivity(intent);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
    }

    @JavascriptInterface
    public void setGalleries(String response) {
        try {
            JSONObject jo = new JSONObject(response);
            if (jo.has("images")) {
                mImageList = new ArrayList<>();
                JSONArray images = jo.getJSONArray("images");
                for (int i = 0; i < images.length(); i++) {
                    mImageList.add(images.getString(i));
                }
            }
            Log.e(tag, mImageList.size() + ":::setGalleries");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @JavascriptInterface
    public void gallery(String response) {

        try {
            JSONObject jo = new JSONObject(response);
            final int index = jo.getInt("index");
            if (mImageList != null && mImageList.size() > 0) {
                final String[] urls = mImageList.toArray(new String[mImageList.size()]);
                Toast.makeText(BaseApp.getInstance(), "这个地方显示图片:" + urls.length, Toast.LENGTH_SHORT).show();

                //TODO:webview展示图片详情在这里!
                PopVp popVp = new PopVp();
                popVp.setIndex(index);
                popVp.setmImageList(mImageList);

                EventBus.getDefault().postSticky(popVp);

//                Intent intent = new Intent(BaseApp.getInstance(), WebViewActivity.class);
//                BaseApp.getInstance().startActivity(intent);
////                PhotoBrowserActivity.getData(urls,BaseApp.getInstance());
//                BaseApp.getInstance().startActivity(intent);
//                Intent intent = new Intent(BaseApp.getInstance(), PhotoBrowserActivity.class);
//                intent.putExtra("urls",urls);
//                BaseApp.getInstance().startActivity(intent);
//                Glide.with(BaseApp.getInstance()).load(urls[position]).into(img);

                //彈窗
//                View view = View.inflate(BaseApp.getInstance(), R.layout.viewpage_item_imageview, null);
//                final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//                RelativeLayout rlt = view.findViewById(R.id.rlt);
//                //点击弹窗外部  弹窗消失    背景
//                popupWindow.setBackgroundDrawable(null);
//                popupWindow.setOutsideTouchable(true);
//                popupWindow.showAtLocation(rlt, Gravity.CENTER,0,0);// 位于父容器中的 位置
//                ViewPager vp = view.findViewById(R.id.img_vp);
//                vp.setAdapter(new PagerAdapter() {
//                    @Override
//                    public int getCount() {
//                        return urls.length;
//                    }
//                    @Override
//                    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//                        return view == object;
//                    }
//                    @NonNull
//                    @Override
//                    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//                        View view1 = View.inflate(BaseApp.getInstance(), R.layout.viewpage_item_imageview2, null);
//                        ImageView img = view1.findViewById(R.id.img_content);
//                        Glide.with(BaseApp.getInstance()).load(urls[position]).into(img);
//                        return view1;
//                    }
//                    @Override
//                    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
////                        super.destroyItem(container, position, object);
//                        container.removeView((View) object);
//                    }
//                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public void play(String type, String src, String stream) {
        play(type, src, stream, null);
    }

    @JavascriptInterface
    public void play(final String type, final String src, String stream, final String refer) {
        Log.e(tag, "type  =  " + type + "  src  =" + src + "  stream  = " + stream);
        if (!TextUtils.isEmpty(stream)) {
            if (!stream.startsWith("http")) {
                stream = NetPort.BASEURL + "/video/play/" + stream;
                if (stream.startsWith("https")) {
                    stream = stream.replaceAll("https", "http");
                }
            }

        }
        final String videoStream = stream;
//        playVideo(type, src, videoStream, refer);
        Toast.makeText(BaseApp.getInstance(), "播放视频把", Toast.LENGTH_SHORT).show();
    }

    /**
     * @param url    浏览器的连接
     * @param target 0:打开应用内浏览器   1:打开外部浏览器
     * @param title  应用内浏览器标题
     */
    @JavascriptInterface
    public void startBrowser(final String url, final int target, final String title) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
//        playVideoByBrowser(url, target, title);
        Toast.makeText(BaseApp.getInstance(), "打开浏览器", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void jumpInnerPage(final String url) {
       /* mWebContent.post(new Runnable() {
            @Override
            public void run() {
                mNewsUrl = url;
                loadWithUrl();
            }
        });*/
        Toast.makeText(BaseApp.getInstance(), "打开一个什么地址", Toast.LENGTH_SHORT).show();
    }

    /**
     * js调用分享
     */
    @JavascriptInterface
    public void appShare(final String json) {
        /*if (mWebViewJSCallBack != null) {
            mWebViewJSCallBack.appShare(json);
        }*/
        Toast.makeText(BaseApp.getInstance(), "这是个分享功能", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void getAuthorization() {
        Toast.makeText(BaseApp.getInstance(), "这个地方调用了js里的一个方法，和token、UUID有关", Toast.LENGTH_SHORT).show();
       /* mWebContent.post(new Runnable() {
            @Override
            public void run() {
                JSONObject jo = new JSONObject();
                try {
                    UserEntity user = DatabaseHelper.getLocalUser(getContext());
                    if (user != null && user.getAccess_token() != null) {
                        jo.put("Authorization", user.getAccess_token());
                    } else {
                        jo.put("Authorization", "");
                    }
                    jo.put("UUID", AppUtils.getUUID(getContext()));
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                String js = "javascript: set_Authorization( " + jo.toString() + ")";
                mWebContent.loadUrl(js);
            }
        });*/
    }

    @JavascriptInterface
    public void payMoney(final String json) {
        Toast.makeText(BaseApp.getInstance(), "支付功能", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void shareUrl(final String url, final String title, final String desc, final String shareTitle) {
        /*if (mWebViewJSCallBack != null) {
            mWebViewJSCallBack.shareUrl(url, title, desc, shareTitle);
        }*/
        Toast.makeText(BaseApp.getInstance(), "fenxiang功能", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void shareArticle(final String json) {
        Toast.makeText(BaseApp.getInstance(), "分享文章", Toast.LENGTH_SHORT).show();
    }


    @Override
    @JavascriptInterface
    public void cancel_order(final String orderNo) {
        if (TextUtils.isEmpty(orderNo))
            return;
        Toast.makeText(BaseApp.getInstance(), "取消命令", Toast.LENGTH_SHORT).show();
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                cancelOrder(orderNo);
//            }
//        });
    }

    @Override
    @JavascriptInterface
    public void pay(final String orderNo, final String orderPrice) {
        Toast.makeText(BaseApp.getInstance(), "又是支付功能", Toast.LENGTH_SHORT).show();
      /*  getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(orderNo)) {
                    ToastUtils.showToast(AppCore.app(), getString(R.string.pay_order_no_empty));
                    return;
                }
                mH5PayOrderNo = orderNo;
                final ProgressDialog dialog = new ProgressDialog(getContext());
                dialog.show();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        NewsDetailFragment.this.pay(dialog, orderNo, orderPrice);
                    }
                });
            }
        });*/
    }
}
