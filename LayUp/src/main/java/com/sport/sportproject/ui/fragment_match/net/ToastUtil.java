package com.sport.sportproject.ui.fragment_match.net;

import android.widget.Toast;

import com.sport.sportproject.base.BaseApp;


/**
 * Created by $lzj on 2019/5/5.
 */
public class ToastUtil {
    public static void showShort(String msg){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(BaseApp.getInstance(),msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(BaseApp.getInstance(),msg,Toast.LENGTH_LONG).show();
    }
}
