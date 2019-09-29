package com.sport.sportproject.ui;

import android.content.Context;
import android.content.Intent;

/**
 * Created by 华为 on 2019/7/21.
 */

public class MJavascriptInterface {

    private Context context;

    private String [] imageUrls;


    public MJavascriptInterface(Context context,String[] imageUrls) {

        this.context = context;

        this.imageUrls = imageUrls;

    }


    @android.webkit.JavascriptInterface
    public void openImage(String img) {

        Intent intent = new Intent();

        intent.putExtra("imageUrls", imageUrls);

        intent.putExtra("curImageUrl", img);
        //跳转页面
        intent.setClass(context, PhotoBrowserActivity.class);

        context.startActivity(intent);
    }
}
