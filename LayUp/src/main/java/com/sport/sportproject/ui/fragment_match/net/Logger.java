package com.sport.sportproject.ui.fragment_match.net;

import android.util.Log;

import com.sport.sportproject.BuildConfig;

/**
 * Created by $lzj on 2019/5/5.
 */
public class Logger {
    public static void logD(String tag,String msg){
        if (BuildConfig.DEBUG){
            Log.d(tag, "logD: "+msg);
        }
    }
}
