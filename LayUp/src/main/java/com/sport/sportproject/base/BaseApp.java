package com.sport.sportproject.base;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.multidex.MultiDex;
import android.util.Log;
import com.sport.sportproject.utils.DeviceUuidFactory;
import com.sport.sportproject.utils.NetBroadcastReceiver;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.qcloud.tim.demo.DemoApplication;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
/**
 * 苏克阳 实训进阶
 */
public class BaseApp extends DemoApplication {
    protected static  BaseApp sBaseApp;
    public String mToken = "";
    public boolean mImIsLogin = false;
    private NetBroadcastReceiver netWorkChangReceiver;
    private UUID mUuid;
    public boolean mPlayInWifi;
    private RefWatcher refWatcher;
    public static BaseApp getInstance() {
        return sBaseApp;
    }
    @SuppressLint("NewApi")
    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
        mUuid = DeviceUuidFactory.getInstance(getApplicationContext()).getDeviceUuid();
        Log.e("uuid:", mUuid + "\n" + mUuid.toString());
        if (Build.VERSION.SDK_INT >= 28) {
            closeAndroidPDialog();
        }
        //UMENG友盟
        intiUmeng();
        //检验内存
        refWatcher = setupLeakCanary();
    }
    private void intiUmeng() {
        //5d40ef6d4ca357a9e600072a
        UMConfigure.init(this, "5d40ef6d4ca357a9e600072a", "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        //需要设置各个平台的appkey：
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setSinaWeibo("2248884681", "7ed722f6244fb5ce4504b4fe46c394bb", "http://sns.whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
    //检测内存泄漏
    private RefWatcher setupLeakCanary(){
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        BaseApp leakApplication = (BaseApp) context.getApplicationContext();
        return leakApplication.refWatcher;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
    /**
     * 通过反射解决在Android 9.0 (Android P) 出现的错误弹窗
     */
    private void closeAndroidPDialog() {
        try {
            @SuppressLint("PrivateApi") Class aClass = Class.forName("android.content.pm.PackageParser$Package");
            Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            @SuppressLint("PrivateApi") Class cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread");
            declaredMethod.setAccessible(true);
            Object activityThread = declaredMethod.invoke(null);
            Field mHiddenApiWarningShown = cls.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
