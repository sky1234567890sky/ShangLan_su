package com.sport.sportproject.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.interfaces.Config;

import java.util.HashMap;
import java.util.Map;


public class NetHeaders {

    public static Map getHeadMap() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Pragma", "no-cache");
        headers.put("Cache-Control", "no-cache");
        headers.put("charset", "UTF-8");
        headers.put("Authorization", BaseApp.getInstance().mToken);
        headers.put("UUID", getUUID());
        headers.put("UUIDX", getUUIDX());

        headers.put("device-tag", "0");//设备的标志
        headers.put("fingerprint-shumei", getShuMei_UUID());
        headers.put("User-Agent", getUserAgent());//默认
        headers.put("lang", "zh-cn");
//        headers.put("android-channel", getChannel(context));
//        headers.put("encrypt-id", getEncryptId());
        return headers;
    }

    public static String getUUID() {
        return "@3bG+xodwLGufwUwmUTamG2RHRiyTxTp3L4NE+UYLfB2vXxF4RTwG3QFQV/LQoUC5QUAMmmmgeE2A/1aoh3BjqpdOH/iZ/jPu7LY4zAg4iog=";
    }

    public static String getUUIDX() {
        return "@3bG+xodwLGufwUwmUTamG2RHRiyTxTp3L4NE+UYLfB2vXxF4RTwG3QFQV/LQoUC5QUAMmmmgeE2A/1aoh3BjqpdOH/iZ/jPu7LY4zAg4iog=";
    }

    public static String getShuMei_UUID() {
        return "20190320130857dce966d2d11fbd35e63f32d9e73ebc5d01ba216d07ea74cc";
    }

    public static String getUserAgent() {
        int versionCode = 1;
        try {
            versionCode = BaseApp.getInstance().getPackageManager().getPackageInfo(BaseApp.getInstance().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException pE) {
            pE.printStackTrace();
        }
        String webviewAgent = (String) SharedPreferencesUtils.getParam(Config.USER_AGENT, "");
        return webviewAgent + " News/" + versionCode + " Android/"
                + versionCode + " NewsApp/" + versionCode + " SDK/"
                + Build.VERSION.SDK_INT + " VERSION/"
                + getVersionName();

    }

    public static String getVersionName() {
        try {
            PackageManager manager = BaseApp.getInstance().getPackageManager();
            PackageInfo info = manager.getPackageInfo(BaseApp.getInstance().getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "unknown";
    }
}
