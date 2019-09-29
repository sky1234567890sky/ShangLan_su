package com.example.logindemo.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.logindemo.R;
import com.example.logindemo.list.adapter.Main2Adapter;
import com.example.logindemo.list.bean.DataBean2;
import com.example.logindemo.list.bean.DataBeans;
import com.example.logindemo.list.adapter.MyServer;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 三级列表
 */
public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private List<DataBean2.ChildsBeanXX> list;
        private Main2Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initView();
//        initData();
        initRetrofir();
    }

    private void initView() {
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mRlv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        adapter = new Main2Adapter(list);
        mRlv.setAdapter(adapter);
    }

    private void initRetrofir() {
        Retrofit rf = new Retrofit.Builder()
                .baseUrl(MyServer.path)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //appEName=GJZC_ZG_QKYX_YTMJ&clientver=ying.ksbao.com&v=0.0798874373443609
        rf.create(MyServer.class).getData("GJZC_ZG_QKYX_YTMJ", "ying.ksbao.com", 0.0798874373443609).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

                .subscribe(new Observer<DataBeans>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(DataBeans dataBeans) {

                        DataBeans.DataBean data = dataBeans.getData();

                        String chapterMenuJson = data.getChapterMenuJson();
//                        Log.i("tag", "onNext: "+chapterMenuJson);
                        DataBean2 dataBean2 = new Gson().fromJson(chapterMenuJson, DataBean2.class);

                        List<DataBean2.ChildsBeanXX> childs = dataBean2.getChilds();

                        adapter.setDatas(dataBean2);
                        list.addAll(childs);

                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(Main2Activity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }


    private void initData() {
        String path = "https://slb-exam-test.ksbao.com/api/chapterMenu/getChapterMenuX?appEName=GJZC_ZG_QKYX_YTMJ&clientver=ying.ksbao.com&v=0.07988743734436099";
        OkHttpClient build = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .get()
                .url(path)
                .build();
        build.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                Toast.makeText(Main2Activity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i("tag", "错误: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String string = response.body().string();
                final Gson gson = new Gson();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        DataBeans dataBean = gson.fromJson(string, DataBeans.class);
//
//                        String chapterMenuJson = dataBean.getData().getChapterMenuJson();
//
//                        DataBean2 dataBean2 = gson.fromJson(chapterMenuJson, DataBean2.class);
//
//                        adapter.setDatas(dataBean2.getChilds());
//
//                    }
//                });
            }
        });
    }
}