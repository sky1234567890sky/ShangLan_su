package com.sport.sportproject.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;

public class GetVersionUtils {
    /**
     * 获取版本号
     *
     * @param context
     * @return
     */
    @SuppressLint("WrongConstant")
    public static int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            // 获取软件版本号
            versionCode = context.getPackageManager().getPackageInfo(
                    "com.example.damin.myproject", 1).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取版本名称
     *
     * @param context
     * @return
     */
    @SuppressLint("WrongConstant")
    public static String getVersionName(Context context) {
        String versionName = "";
        try {
            // 获取软件版本名称
            versionName = context.getPackageManager().getPackageInfo(
                    "com.example.damin.myproject", 1).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }


}
