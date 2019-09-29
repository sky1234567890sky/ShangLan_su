package com.sport.sportproject.ui.activity_main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.base.BaseMvpActivity;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.bean.bean.navigation.NavigationBean;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.interfaces.im.ImHelper;
import com.sport.sportproject.ui.SearchActivity;
import com.sport.sportproject.ui.activity_login.LoginActivity;
import com.sport.sportproject.ui.fragment_circlezi.Fragment_CircleZi;
import com.sport.sportproject.ui.fragment_data.Fragment_Data;
import com.sport.sportproject.ui.fragment_mainpage.fragment.Fragment_MainPage;
import com.sport.sportproject.ui.fragment_match.fragement.Fragment_Match;
import com.sport.sportproject.ui.main_navigation.Navigation_Rlv_Adapter;
import com.sport.sportproject.ui.main_navigation.SettingActivity;
import com.sport.sportproject.utils.GetVersionUtils;
import com.sport.sportproject.utils.InstallUtil;
import com.sport.sportproject.utils.NetHeaders;
import com.sport.sportproject.utils.NetVersionInfo;
import com.sport.sportproject.utils.SharedPreferencesUtils;
import com.sport.sportproject.utils.SharedPrefrenceUtils;
import com.sport.sportproject.utils.StatusBarUtil;
import com.sport.sportproject.utils.ToastUtil;
import com.sport.sportproject.utils.VersionCode;
import com.tencent.qcloud.tim.demo.login.LoginForDevActivity;
import com.tencent.qcloud.tim.demo.signature.GenerateTestUserSig;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import org.raphets.roundimageview.RoundImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import razerdp.design.DialogPopup;
import retrofit2.Retrofit;

public class MainActivity extends BaseMvpActivity<BasePublicPresenter, MainActivityModel> implements PublicView, DialogPopup.DialogClickCallBack {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.headler_img_tooolbar)
    RoundImageView headler_img;


    @BindView(R.id.login_last_headler_img)
    RoundImageView last_headler_img;//登录后的侧滑的头像显示

    @BindView(R.id.wel_name)
    TextView user;
    @BindView(R.id.wel_state)
    TextView state;
    @BindView(R.id.container)
    FrameLayout mContainer;
    @BindView(R.id.tv_dajia)
    TextView mTvDaijia;
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.draw)
    DrawerLayout mDraw;
    @BindView(R.id.a_pure_and_loving_world_of_basketball)
    TextView mAPureAndLovingWorldOfBasketball;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.tv_title_main)
    TextView mTvTitleMain;
    @BindView(R.id.ll_system_message)
    LinearLayout mLlSystemMessage;
    @BindView(R.id.ll_search)
    LinearLayout mLlSearch;
    @BindView(R.id.ll_setting)
    LinearLayout mLlSetting;
    @BindView(R.id.ll_navigation)
    LinearLayout mLlNavigation;
    @BindView(R.id.ll_MeNotifition)
    LinearLayout mLlMeNotifition;
    @BindView(R.id.ll_collect)
    LinearLayout mLlCollect;

    private ArrayList<NavigationBean.ModulesBean> navigationBeans = new ArrayList<>();
    private Navigation_Rlv_Adapter navigation_rlv_adapter;
    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> titles;
    private ArrayList<Integer> Icons;
    private int mPosition;

    private long exittime;
    private TextView mTabTv;
    private ImageView mTabIv;
    private Animation animation;
    private DialogPopup mDialogPopup;
    private NetVersionInfo info;
    private File sd;
    private ProgressBar mProgress;
    private long count;
    private String mPath;
    private String headlerimg_url;
    private static final int REQ_PERMISSION_CODE = 0x100;
    private String account;


    /**
     * 初始化标题
     */
    private void initTitle() {
        StatusBarUtil.setTranslucentStatus(this);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        titles = new ArrayList<>();
        titles.add(R.string.mainpage);
        titles.add(R.string.match);
        titles.add(R.string.circlezi);
        titles.add(R.string.data);
        Icons = new ArrayList<>();
        Icons.add(R.drawable.lib_icon_tab1_select);
        Icons.add(R.drawable.lib_icon_tab2_select);
        Icons.add(R.drawable.lib_icon_tab3_select);
        Icons.add(R.drawable.lib_icon_tab4_select);
    }

    /**
     * 展示默认的Fragment
     */
    private void ShowDefaultFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragments.get(0));
        transaction.commit();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment_MainPage());//首页
        fragments.add(new Fragment_Match());//比赛
        fragments.add(new Fragment_CircleZi());//圈子
        fragments.add(new Fragment_Data());//数据
    }

    /**
     * 初始化Tablayout
     */
    private void initTabLayout() {
        for (int i = 0; i < titles.size(); i++) {
            mTab.addTab(mTab.newTab().setText(titles.get(i)));
            TabLayout.Tab tabAt = mTab.getTabAt(i);
            View inflate = LayoutInflater.from(BaseApp.getInstance()).inflate(R.layout.tab, null);
            mTabIv = inflate.findViewById(R.id.tab_iv);
            mTabTv = inflate.findViewById(R.id.tab_tv);
            mTabIv.setImageResource(Icons.get(i));
            mTabTv.setText(titles.get(i));
            if (i == 0) {
                mTabTv.setTextColor(ContextCompat.getColor(BaseApp.getInstance(), R.color.c_e34536));
            }
            tabAt.setCustomView(inflate);
        }
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                View customView = tab.getCustomView();
                ImageView mIv = customView.findViewById(R.id.tab_iv);
                TextView mTv = customView.findViewById(R.id.tab_tv);
                SwitchFragment(position);
                SwitchTitle(position);
                mPosition = position;
                mTv.setTextColor(ContextCompat.getColor(BaseApp.getInstance(), R.color.c_e34536));
                mIv.startAnimation(animation);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                TextView mTv = customView.findViewById(R.id.tab_tv);
                mTv.setTextColor(ContextCompat.getColor(BaseApp.getInstance(), R.color.c_222));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                ImageView mTabIV = customView.findViewById(R.id.tab_iv);
                mTabIV.startAnimation(animation);
            }
        });
    }

    private void SwitchTitle(int position) {
        switch (position) {
            case 0:
                mTvDaijia.setVisibility(View.VISIBLE);
                mTvTitleMain.setVisibility(View.GONE);
                break;
            case 1:
                addTitle(R.string.match);
                break;
            case 2:
                addTitle(R.string.circlezi);
                break;
            case 3:
                addTitle(R.string.data);
                break;
        }
    }

    private void addTitle(int type) {
        mTvTitleMain.setVisibility(View.VISIBLE);
        mTvDaijia.setVisibility(View.GONE);
        mTvTitleMain.setText(type);
    }

    private void SwitchFragment(int position) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = fragments.get(position);
        if (!fragment.isAdded()) {
            transaction.add(R.id.container, fragment);
        }
        transaction.hide(fragments.get(mPosition));
        transaction.show(fragment);
        transaction.commit();
    }

    /**
     * 侧滑初始化布局
     */
    private void initNavigation() {
        mRlv.setLayoutManager(new GridLayoutManager(BaseApp.getInstance(), 3));
        navigation_rlv_adapter = new Navigation_Rlv_Adapter(navigationBeans);
        mRlv.setAdapter(navigation_rlv_adapter);
    }

    /**
     * 请求数据成功后返回的数据
     *
     * @param type    区分
     * @param objects 可变参数
     */
    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                NavigationBean navigationBean = (NavigationBean) objects[0];
                navigationBeans.addAll(navigationBean.getModules());
                navigation_rlv_adapter.notifyDataSetChanged();
                break;
        }
        hideLoadingDialog();
    }
    /**
     * 失败回调
     *
     * @param e
     */
    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showShort(e.getMessage());
    }
    /**
     * 点击事件
     * @param v
     */
    @SuppressLint("RtlHardcoded")
    @OnClick({R.id.headler_img_tooolbar, R.id.tv_login, R.id.ll_system_message, R.id.ll_search, R.id.ll_setting, R.id.tv_dajia, R.id.ll_MeNotifition, R.id.ll_collect, R.id.login_last_headler_img})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.headler_img_tooolbar:
                mDraw.openDrawer(Gravity.LEFT);
                break;
            case R.id.tv_login: // 立即登录
                IsLogin();
                break;
                //TODO:IM在这
            case R.id.ll_system_message: // 系统消息
                //跳转到对话界面
                if (mApplication.mImIsLogin){
                    startActivity(new Intent(this, com.tencent.qcloud.tim.demo.main.MainActivity.class));
                }else{
                    loginIm(2);
                }
                break;
            case R.id.ll_search: // 搜索
                SearchActivity.go2Activity(this);
                break;
            case R.id.ll_setting: // 设置
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                break;
            case R.id.tv_dajia:
                SearchActivity.go2Activity(this);
                break;
            case R.id.ll_MeNotifition:
                break;
            case R.id.ll_collect:
                break;
            case R.id.login_last_headler_img://已登录状态的侧滑页面显示的头像
                //应该跳转到注销页面
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                break;
        }
        AnimationFinish();
    }
    public static boolean checkPermission(Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> permissions = new ArrayList<>();
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(TUIKit.getAppContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(TUIKit.getAppContext(), Manifest.permission.CAMERA)) {
                permissions.add(Manifest.permission.CAMERA);
            }
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(TUIKit.getAppContext(), Manifest.permission.RECORD_AUDIO)) {
                permissions.add(Manifest.permission.RECORD_AUDIO);
            }
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(TUIKit.getAppContext(), Manifest.permission.READ_PHONE_STATE)) {
                permissions.add(Manifest.permission.READ_PHONE_STATE);
            }
            if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(TUIKit.getAppContext(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (permissions.size() != 0) {
                String[] permissionsArray = permissions.toArray(new String[1]);
                ActivityCompat.requestPermissions(activity,
                        permissionsArray, REQ_PERMISSION_CODE);
                return false;
            }
        }

        return true;
    }

    /**
     * 系统请求权限回调
     */
    private void IsLogin() {
        boolean isLogin = (boolean) SharedPreferencesUtils.getParam("isLogin", false);
        if(isLogin) {//判断登录状态

        } else {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
    @SuppressLint("NewApi")
    private void AnimationFinish() {
        overridePendingTransition(R.anim.enter_right, R.anim.exit_left);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - exittime) > 2000) {
                ToastUtil.showShort("再按一次则退出上篮");
                exittime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onBackPressed() {
        onStateNotSaved();
        super.onBackPressed();
    }
    @Override
    protected MainActivityModel initModel() {
        return new MainActivityModel();
    }
    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }
    /**
     * 进行监听事件
     */
    @Override
    protected void initListener() {

    }
    /**
     * 用网络请求数据
     */
    @Override
    protected void initData() {
        showLoadingDialog();
        //刚进入的状态（超过7天未登录就登录）
        loginIm(1);
        mPresenter.getData(Params.REQUEST_ONE);
        findNetVersion();
    }
    //判断用户是否是登录状态
    private void loginIm(final int index) {
        if (index == 1 && mApplication.mImIsLogin)
            return;
//        TextUtils.isEmpty(mApplication.mUserNick)
        if (TextUtils.isEmpty(mApplication.mUserNick)) {
            ToastUtil.showShort("用户未登录");
            return;
        }
        account = mApplication.mUserNick;
        //用户长时间未登录7天就推出了
        String userSig = GenerateTestUserSig.genTestUserSig(account);

        TUIKit.login(account, userSig, new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {
                ToastUtil.showShort("登陆成功");
                mApplication.mImIsLogin=true;
                ImHelper.getSelfInfo();
                if (index==2){
                    startActivity(new Intent(MainActivity.this, com.tencent.qcloud.tim.demo.main.MainActivity.class));
                }
            }
            @Override
            public void onError(String module, int errCode, String errMsg) {
                ToastUtil.showShort("登录失败, errCode = " + errCode + ", errInfo = " + errMsg);
                mApplication.mImIsLogin = false;
            }
        });
    }
    private void findNetVersion() {
        //升级更新接口
        Rx2AndroidNetworking.get("https://www.cpzs.org/admin/apkversion/getxml/17")
                .build()
                .getStringObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                        info = parseVersion(s);
                        //获取公共请求头
                        String versionName = NetHeaders.getVersionName();
                        float v = Float.parseFloat(VersionCode.getAppVersionCode(BaseApp.getInstance()));
                        //获取系统版本
                        String appVersionCode = VersionCode.getAppVersionCode(BaseApp.getInstance());
//                        ToastUtil.showLong("服务器版本："+Integer.parseInt(info.version));
                        if (Integer.parseInt(appVersionCode) < Integer.parseInt(info.version)) {
                            checkVersion(info, versionName);
                        }
                    }
                });
    }

    private void checkVersion(NetVersionInfo info, String versionName) {
        if (!info.version.equals(versionName)) {
            mDialogPopup = new DialogPopup(this, !info.isforceUpdate);
            mDialogPopup.setDialogClickCallBack(this);
            if (info.isforceUpdate) {
//               mDialogPopup.setOutSideTouchUnDisMiss();
            }
            mDialogPopup.setContent("发现新版本，是否升级");
            mDialogPopup.showPopupWindow();
        }
    }

    @Override
    public void okClick() {
        if (mDialogPopup != null) {
            mDialogPopup.dismiss();
        }
        ToastUtil.showShort("开始下载");
        //下载逻辑
        initDownLoad();
    }

    private void initDownLoad() {
        String url = info.getUrl();

        //读取手机属于危险性权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            readSD();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission
                    .WRITE_EXTERNAL_STORAGE}, 100);
        }
    }
    //下载的回调
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQ_PERMISSION_CODE) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                ToastUtil.showShort("未全部授权，部分功能可能无法使用！");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readSD();
                }
                break;
        }
    }

    //允许下载
    private void readSD() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            sd = Environment.getExternalStorageDirectory();
        }
        retrofit(sd + "/" + "LayUp.apk");
    }
    private void retrofit(final String path) {

        new OkHttpClient.Builder().build().newCall(new Request.Builder().url(info.getUrl()).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();

                InputStream inputStream = body.byteStream();

                long max = body.contentLength();
                //文件下载保存
                saveFile(inputStream, path, max);
            }
        });
    }

    private void saveFile(InputStream inputStream, final String path, final long max) {

        try {
            FileOutputStream fos = new FileOutputStream(new File(path));

            count = 0;

            int length = -1;

            byte[] bys = new byte[1024 * 10];

            while ((length = inputStream.read(bys)) != -1) {
                fos.write(bys, 0, length);

                count += length;
                Log.e("tag", "count:" + count + "max:" + max);
                //进度条和视频播放SurfaceView可以直接在子线程中刷新
                this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //通知
                        //发送通知
                        //1,获取NoitificationManage对象
                        NotificationManager systemService = (NotificationManager) BaseApp.getInstance().getSystemService(Context.NOTIFICATION_SERVICE);
                        String ChannelId = "1";
                        String ChannelName = "default";
                        //初始化Notification对象，创建通道对象
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            NotificationChannel channel = new NotificationChannel(ChannelId, ChannelName, NotificationManager.IMPORTANCE_DEFAULT);
                            channel.enableLights(true);//开启指示灯
                            channel.setLightColor(Color.RED);//指示灯颜色
                            channel.setShowBadge(true);//检测是否显示角标
                            systemService.createNotificationChannel(channel);
                        }
                        Notification build = new NotificationCompat.Builder(BaseApp.getInstance(), "1")
                                .setSmallIcon(R.drawable.shanglan)//设置小图
                                .setLargeIcon(BitmapFactory.decodeResource(BaseApp.getInstance().getResources(), R.drawable.ic_launcher_background))//设置大图
//                                .setContentIntent(activities)//设置延时意图
                                .setContentTitle("上篮正在下载....")
                                .setDefaults(Notification.DEFAULT_ALL)//设置提示效果
                                .setSmallIcon(R.mipmap.btn_following_both_pressed)//设置设置角标样式
                                .setAutoCancel(true)//设置点击自动消失
                                .setProgress((int) max, (int) count,false)
                                .setNumber(3)//设置角标计数
                                .build();
                        //4.调用NotificationManager 方法notify()发送通知
                        systemService.notify(100, build);
                        // 设置通知的特性: 通知被点击后，自动消失
                    }
                });
            }
            inputStream.close();
            fos.close();
            runOnUiThread(new Runnable() {
                @SuppressLint("NewApi")
                @Override
                public void run() {

                    ToastUtil.showLong("下载完成");

                    mPath = path;

                    new AlertDialog.Builder(MainActivity.this,100)
                            .setTitle("安装包下载完毕是否进行安装")
                            .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //安装
                                    InstallUtil.installApk(MainActivity.this, path);
                                }
                            }).setNegativeButton("取消",null)
                            .show();
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 8.0安装处理
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == InstallUtil.UNKNOWN_CODE) {
            InstallUtil.installApk(MainActivity.this, mPath);//再次执行安装流程，包含权限判等
        }
    }

    @Override
    public void cancelClick() {
        if (mDialogPopup != null) {
            mDialogPopup.dismiss();
        }
    }
    private NetVersionInfo parseVersion(String s) {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("updateinfo", NetVersionInfo.class);
        xStream.alias("version", NetVersionInfo.class);
        xStream.alias("url", NetVersionInfo.class);
        xStream.alias("description", NetVersionInfo.class);
        xStream.alias("isforceUpdate", NetVersionInfo.class);
        NetVersionInfo info = (NetVersionInfo) xStream.fromXML(s);
        return info;
    }
    /**
     * 初始化布局
     */
    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        //判断已经登陆了
        headlerimg_url = SharedPrefrenceUtils.getString(this, "headler_img");
        if (!headlerimg_url.equals("")) {
            Glide.with(this).load(headlerimg_url).into(headler_img);
            //状态
            state.setVisibility(View.VISIBLE);
            user.setVisibility(View.VISIBLE);
            user.setText("用户:18898186027");
            mTvLogin.setVisibility(View.GONE);//立即登录按钮隐藏
            last_headler_img.setVisibility(View.VISIBLE);//头像显示
            Glide.with(this).load(headlerimg_url).into(last_headler_img);
        } else {
            mTvLogin.setVisibility(View.VISIBLE);//登录注册
            last_headler_img.setVisibility(View.GONE);
        }
        //删除注销账号再显示mTvLogin，等待重新登录；
        animation = AnimationUtils.loadAnimation(this, R.anim.suo);
        initTitle();
        initNavigation();
        initTabLayout();
        initFragment();
        ShowDefaultFragment();

    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("tag", "onSaveInstanceState: " + outState);
    }
}
