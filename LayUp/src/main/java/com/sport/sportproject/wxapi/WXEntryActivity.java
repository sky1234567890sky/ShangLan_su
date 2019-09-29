package com.sport.sportproject.wxapi;
import android.app.Application;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
/**
 * Created by 华为 on 2019/7/25.
 */

public class WXEntryActivity extends Application{
    private static WXEntryActivity wxEntryActivity;
    @Override
    public void onCreate() {
        super.onCreate();
        wxEntryActivity = this;
        UMConfigure.init(this,"我的AppKey"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
//需要设置各个平台的appkey：
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setSinaWeibo("2248884681", "7ed722f6244fb5ce4504b4fe46c394bb","http://sns.whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        /*
	PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
        PlatformConfig.setAlipay("2015111700822536");
        PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
        PlatformConfig.setPinterest("1439206");
        PlatformConfig.setKakao("e4f60e065048eb031e235c806b31c70f");
        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
        PlatformConfig.setVKontakte("5764965","5My6SNliAaLxEm3Lyd9J");
        PlatformConfig.setDropbox("oz8v5apet3arcdy","h7p2pjbzkkxt02a");
        PlatformConfig.setYnote("9c82bf470cba7bd2f1819b0ee26f86c6ce670e9b");
*/
    }
}
