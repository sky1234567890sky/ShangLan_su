package com.sport.sportproject.ui.activity_login;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.XXPermissions;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseActivity;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.base.BaseMvpActivity;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.bean.bean.login.LoginInfo;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.interfaces.im.NormalConfig;
import com.sport.sportproject.ui.activity_main.MainActivity;
import com.sport.sportproject.utils.BitmapOption;
import com.sport.sportproject.utils.CountDownTimerUtils;
import com.sport.sportproject.utils.DialogFromBottom;
import com.sport.sportproject.utils.SharedPrefrenceUtils;
import com.sport.sportproject.utils.SmsVerifyView;
import com.sport.sportproject.utils.StatusBarUtil;
import com.sport.sportproject.utils.ToastUtil;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMFriendAllowType;
import com.tencent.imsdk.TIMFriendshipManager;
import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.qcloud.tim.demo.signature.GenerateTestUserSig;
import com.tencent.qcloud.tim.uikit.TUIKit;
import com.tencent.qcloud.tim.uikit.base.IUIKitCallBack;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import org.raphets.roundimageview.RoundImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import razerdp.design.SlideFromBottomPopup;
//TakePhoto.TakeResultListener,

public class LoginActivity extends BaseMvpActivity<BasePublicPresenter,LoginModel> implements View.OnClickListener, SmsVerifyView.SmsVerifyCallback{

    //TODO:登录Activity
    @BindView(R.id.et_input_phone_num)
    EditText mEtInputPhoneNum;
    @BindView(R.id.et_input_verfiy)
    EditText mEtInputVerfiy;
    @BindView(R.id.tv_getverfiy)
    TextView mTvGetverfiy;
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.iv_wechat_login)
    ImageView mIvWechatLogin;
    @BindView(R.id.iv_denglu_jiemian_logo)
    RoundImageView img;

    private CountDownTimerUtils countDownTimerUtils;//倒计时
    private File mFile;
    private Uri mImageUri;
    private String mTempPhotoPath;
    private Uri imageUri;
    private String imgurl;
    private TextView btn_xingce;
    private TextView btn_xiangji;
    private TextView btn_back;
    private DialogFromBottom dialogFromBottom;
    private PopupWindow pop;
    private Uri photoUri;// 拍照时返回的uri
    private String TAG = LoginActivity.class.getName();
    private String code;
    //    private TakePhotoImpl mTakePhoto;

    //倒计时
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
//        showLoadingDialog();
        //自定义保存登录IM的信息
        getPermission();
    }

    private void getPermission() {
        XXPermissions.with(this)
                .constantRequest() //可设置被拒绝后继续申请，直到用户授权或者永久拒绝
                //.permission(Permission.SYSTEM_ALERT_WINDOW, Permission.REQUEST_INSTALL_PACKAGES) //支持请求 6.0 悬浮窗权限 8.0 请求安装权限
                .permission(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE) //不指定权限则自动获取清单中的危险权限
                .request(new OnPermission() {
                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {

                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {

                        if (denied.size() != 0) ToastUtil.showShort("拒绝权限影响您正常使用");

                    }
                });
        //XXPermissions.gotoPermissionSettings(this);//跳转到权限设置页面
    }

    @Override
    protected void initView() {
        String bitmap = SharedPrefrenceUtils.getString(this, "headler_img");
        if (!bitmap.equals("")) {
            Glide.with(this).load(bitmap).into(img);
        }
        StatusBarUtil.setTranslucentStatus(this);

        countDownTimerUtils = new CountDownTimerUtils(mTvGetverfiy, 60000, 1000);
//        View   dialogContent = LayoutInflater.from(BaseApp.getInstance()).inflate(R.layout.dialog_layout, null, false);
//        dialogFromBottom = new DialogFromBottom(BaseApp.getInstance());
//        dialogFromBottom.setContentView(dialogContent);
//        TextView camera = dialogContent.findViewById(R.id.open_from_camera);
//        TextView photos = dialogContent.findViewById(R.id.open_album);
//        TextView cancel = dialogContent.findViewById(R.id.cancel);
//        camera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //相册
//                initXingce();
//            }
//        });
//        photos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //拍照
//                initXingji();
//            }
//        });
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialogFromBottom.dismiss();
//            }
//        });
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_login;
    }

    //R.id.iv_wechat_login,R.id.iv_sank_login,R.id.tv_login,
    @SuppressLint("NewApi")
    @OnClick({R.id.iv_wechat_login, R.id.iv_sank_login, R.id.iv_qq_login, R.id.iv_back, R.id.tv_login, R.id.tv_getverfiy, R.id.iv_denglu_jiemian_logo})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_login:
                String mEtPhonenumLength = mEtInputPhoneNum.getText().toString().trim();
                String mEtVerfiyCode = mEtInputVerfiy.getText().toString().trim();
                String regex = "1[3,5,7,8][0-9]{9}";
                if (!mEtPhonenumLength.equals("") && mEtPhonenumLength.matches(regex)) {
                    //与服务器返回的数据相同
                    if (!mEtVerfiyCode.equals("") && mEtVerfiyCode.equals(code)){
//                        mApplication.mImIsLogin=true;
                        Intent intent = new Intent(this, MainActivity.class);
                        //保存头像跟手机号
                        SharedPrefrenceUtils.saveString(BaseApp.getInstance(), "headler_img", imgurl);
                        SharedPrefrenceUtils.saveString(BaseApp.getInstance(),  NormalConfig.USER_PHOTO, imgurl);
                        SharedPrefrenceUtils.saveString(BaseApp.getInstance(), "phone", mEtPhonenumLength);
                        SharedPrefrenceUtils.saveString(BaseApp.getInstance(), "nickname", "come on!");
                        loginIm();
                        startActivity(intent);
                        ToastUtil.showShort("登录成功!");
                    }else{
                        ToastUtil.showShort("请先输入手机号");
                    }
                } else {
                    ToastUtil.showShort("请输入正确形式的格式手机号");
                }
                break;
            case R.id.iv_back:
                finish();
                overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
                break;
            case R.id.iv_wechat_login:
                login(SHARE_MEDIA.WEIXIN);
                break;
            case R.id.iv_qq_login:
                //qq登录
                login(SHARE_MEDIA.QQ);
                break;
            case R.id.iv_sank_login:
                login(SHARE_MEDIA.SINA);
                break;
            case R.id.tv_getverfiy:
                countDownTimerUtils.start();
                ToastUtil.showShort("验证码已发送请注意查收");
                initCode();
                break;
            case R.id.iv_denglu_jiemian_logo:
                initPop();
                break;
        }
    }

    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.LOGIN_ACC:
                LoginInfo loginInfo = (LoginInfo) objects[0];
                ToastUtil.showShort(loginInfo.msg);
                Log.i("tag", "LoginInfo: ----->"+loginInfo.toString());
                mApplication.mToken = loginInfo.token;
                mApplication.mUserNick = loginInfo.nick;
                SharedPrefrenceUtils.saveString(this, NormalConfig.TOKEN, loginInfo.token);
                SharedPrefrenceUtils.saveString(this, NormalConfig.USER_NICK, loginInfo.nick);
                loginIm();
                break;
        }
//        hideLoadingDialog();
    }
    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showShort(e.getMessage());
    }

    private void loginIm() {

        String account = mApplication.mUserNick;

        String userSig = GenerateTestUserSig.genTestUserSig(account);

        TUIKit.login(account, userSig, new IUIKitCallBack() {
            @Override
            public void onSuccess(Object data) {
                ToastUtil.showShort("登陆成功");
                mApplication.mImIsLogin = true;
                sycInfoToIm();
            }
            @Override
            public void onError(String module, int errCode, String errMsg) {
                ToastUtil.showShort("登录失败, errCode = " + errCode + ", errInfo = " + errMsg);
                mApplication.mImIsLogin = false;
            }
        });
    }

    private void sycInfoToIm() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TIMUserProfile.TIM_PROFILE_TYPE_KEY_NICK, "苏克阳");
        hashMap.put(TIMUserProfile.TIM_PROFILE_TYPE_KEY_SELFSIGNATURE, "come on!");
        hashMap.put(TIMUserProfile.TIM_PROFILE_TYPE_KEY_ALLOWTYPE,  TIMFriendAllowType.TIM_FRIEND_ALLOW_ANY);
        hashMap.put(TIMUserProfile.TIM_PROFILE_TYPE_KEY_FACEURL, mApplication.mUserPhoto);

        TIMFriendshipManager.getInstance().modifySelfProfile(hashMap, new TIMCallBack() {
            @Override
            public void onError(int i, String s) {
                ToastUtil.showShort("modifySelfProfile err code = " + i + ", desc = " + s);
            }
            @Override
            public void onSuccess() {
                ToastUtil.showShort("信息同步成功");
                getSelfInfo();
            }
        });
    }
    private void getSelfInfo() {
        TIMFriendshipManager.getInstance().getSelfProfile(new TIMValueCallBack<TIMUserProfile>() {
            @Override
            public void onError(int i, String s) {
                ToastUtil.showShort("获取im个人信息失败" + i + ", desc = " +s);
            }
            @Override
            public void onSuccess(TIMUserProfile timUserProfile) {
                mApplication.setSelfInfo(timUserProfile);
                finish();
            }
        });
    }
    @SuppressLint("NewApi")
    private void initPop() {
        pop = new PopupWindow(LoginActivity.this);
        View view = getLayoutInflater().inflate(R.layout.dialog_layout, null);//加载布局

        pop.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);   //设置PopupWindow 一些参数
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        pop.setContentView(view);
        pop.showAtLocation(view, Gravity.BOTTOM, 0, 0);

        LinearLayout parent = (LinearLayout) view.findViewById(R.id.parent);  //最外层布局
        TextView bt1 = (TextView) view.findViewById(R.id.open_from_camera);//相机
        TextView bt2 = (TextView) view.findViewById(R.id.open_album);//相册
        TextView bt3 = (TextView) view.findViewById(R.id.cancel);//关闭
        parent.setOnClickListener(new View.OnClickListener() { // 设置点击最外层布局关闭PopupWindow
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {//相机
                initXingji();
                pop.dismiss();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {//相册
//                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//调用android的图库
//                startActivityForResult(i, 2);
                initXingce();
                pop.dismiss();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pop.dismiss();
            }
        });
    }
    private void login(SHARE_MEDIA TYPE) {
        UMShareAPI umShareAPI = UMShareAPI.get(this);
        umShareAPI.getPlatformInfo(LoginActivity.this, TYPE, new UMAuthListener() {
            /**
             * @param share_media
             */
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Toast.makeText(LoginActivity.this, "失败：" + throwable.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initCode() {
        new OkHttpClient.Builder().build().newCall(new Request.Builder().get()
                .url("http://yun918.cn/study/public/index.php/verify").build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        CodeBean codeBean = new Gson().fromJson(string, CodeBean.class);
                        if (!codeBean.equals("")) {
                            ToastUtil.showShort(codeBean.getData());
                            code = codeBean.getData();
                            mEtInputVerfiy.setText(code);
                        } else {
                            ToastUtil.showShort("验证码有误");
                        }

                    }
                });
            }
        });
    }

    private void initXingce() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            openAlbum();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 200);
        }
    }

    private void initXingji() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            openCamera();//拍照
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == 100) {//拍照
                openCamera();
            } else if (requestCode == 200) {//相册
                openAlbum();
            }
        }
    }

    //拍照
    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//调用android自带的照相机
        photoUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        startActivityForResult(intent, 1);
    }

    /**
     * 点击相册选图
     */
    private void openAlbum() {
        //开启相册
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 2);
//        mTakePhoto = new TakePhotoImpl(LoginActivity.this, (TakePhoto.TakeResultListener) this);
//        mTakePhoto.onEnableCompress(new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(1080).create(), true);
//        mTakePhoto.onPickFromGalleryWithCrop(getUri(), getOption());
//        mTakePhoto.onPickFromGallery();
    }
//  private CropOptions getOption() {
//        return new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(false).create();
//    }

    private Uri getUri() {
        File file = new File(Environment.getExternalStorageDirectory(), "/news10/" + System.currentTimeMillis() + ".png");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);
        return imageUri;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        mTakePhoto.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                Bundle extras = data.getExtras();
                Bitmap photoBit = (Bitmap) extras.get("data");
                Bitmap option = BitmapOption.bitmapOption(photoBit, 5);
                img.setImageBitmap(option);
                final File file = new File("/sdcard/" + "0001.jpg");
                //文件上传
                uploadFile(file);
            } else if (requestCode == 2) {
                //相册选择显示
                //获取到图片对应的Uri路径
                Uri data1 = data.getData();
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(data1));
//                    img.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //将Uri路径转换为对应的File文件
                File mF = getFileFromUri(data1, this);
                //文件上传
                uploadFile(mF);
            }
        }
    }

    private File getFileFromUri(Uri mImageUri, Context context) {
        if (mImageUri == null) {
            return null;
        }
        switch (mImageUri.getScheme()) {
            case "content":
                return getFileFromContentUri(mImageUri, context);
            case "file":
                return new File(mImageUri.getPath());
            default:
                return null;
        }
    }

    private File getFileFromContentUri(Uri mImageUri, Context context) {
        File file = null;
        Cursor cursor = context.getContentResolver().query(mImageUri, new String[]{MediaStore.MediaColumns.DATA}, null, null, null);
        if (cursor != null) {
            if (cursor.moveToNext()) {
                String filePath = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA));
                cursor.close();
                if (!TextUtils.isEmpty(filePath)) {
                    file = new File(filePath);
                }
            }
        }
        return file;
    }

    private void uploadFile(File mFile) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"), mFile);
        MultipartBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("key", "实训2")
                .addFormDataPart("file", mFile.getName(), requestBody)
                .build();
        Request request = new Request.Builder()
                .url("http://yun918.cn/study/public/file_upload.php")
                .post(body)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag", "onFailure: " + e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Gson gson = new Gson();
                final UpLoadBean upLoadBean = gson.fromJson(str, UpLoadBean.class);
                imgurl = upLoadBean.getData().getUrl();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (upLoadBean != null) {
                            if (upLoadBean.getCode() == 200) {
                                Log.e("tag", "run: " + imgurl);
//                                Log.i("", "run: "+upLoadBean.getData().getUrl());
                                Glide.with(LoginActivity.this).load(imgurl).into(img);
                                Toast.makeText(LoginActivity.this, upLoadBean.getRes(), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, upLoadBean.getRes(), Toast
                                        .LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        countDownTimerUtils = null;
    }

    @Override
    protected LoginModel initModel() {
        return new LoginModel();
    }

    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        ToastUtil.showShort(event.getKeyCode());
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            ToastUtil.showShort("enter click");
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public void smsCodeSend() {

    }

    @Override
    public void countryCodeOpen() {

    }
}
