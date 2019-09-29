package com.example.logindemo.list;

import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.logindemo.R;
import com.example.logindemo.list.adapter.Mian3Apapter;
import com.example.logindemo.list.bean.DataBean2;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
//二级
public class Main3Activity extends AppCompatActivity {
    private  List<DataBean2.ChildsBeanXX> list;
//    private  int position;
    @BindView(R.id.rlv2)
    RecyclerView mRlv2;
    private Mian3Apapter apapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);
        initView();

    }
    private void initView() {
        mRlv2.setLayoutManager(new LinearLayoutManager(this));
        mRlv2.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
//        DataBean2.ChildsBeanXX childsBeanXX = list.get(position);
        apapter = new Mian3Apapter(list, this);
        mRlv2.setAdapter(apapter);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getData(List<DataBean2.ChildsBeanXX> childs){
        if (childs!=null){
            list  = childs;
        }
    }
    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBus.getDefault().unregister(this);
    }
}
