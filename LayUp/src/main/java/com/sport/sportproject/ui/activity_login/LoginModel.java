package com.sport.sportproject.ui.activity_login;

import android.util.Log;

import com.sport.sportproject.base.BaseObservable;
import com.sport.sportproject.base.PublicModel;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.bean.bean.login.LoginInfo;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.utils.VerifyCodeInfo;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by 华为 on 2019/7/31.
 */

public class LoginModel implements PublicModel{
    @Override
    public void getData(PublicView view, int type, Object[] objects) {

        BaseObservable manager = BaseObservable.getInstance();

        switch (type) {
            case Params.GET_SMS:
                long millis = System.currentTimeMillis();
                String s = String.valueOf(millis);
                s = s.substring(s.length()-5,s.length()-1);
                VerifyCodeInfo info = new VerifyCodeInfo();
                info.success = true;
                info.verify_token = s;
                try {
                    Thread.sleep(500l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.onSuccess(type,info);
                break;
            case Params.LOGIN_ACC:

                String path = (String) objects[0];
                Log.i("tag", "token------->: "+System.currentTimeMillis()+"");
                LoginInfo loginInfo = new LoginInfo(path, System.currentTimeMillis() + "", "登录成功","sky");

                try {
                    Thread.sleep(500l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                view.onSuccess(type,loginInfo);
                break;
//
            case Params.UPLOAD_IMAGE:
                File file = new File((String) objects[0]);
                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("key", "1806b")
                        .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/png"), file ))
                        .build();
//                manager.getNetMessages(manager.getNetService("http://yun918.cn/").uploadImage(body),view,whichApi);
                break;
        }
    }
}
