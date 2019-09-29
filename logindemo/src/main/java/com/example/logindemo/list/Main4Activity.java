package com.example.logindemo.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.example.logindemo.R;
import com.example.logindemo.list.adapter.Main4Adapter;
import com.example.logindemo.list.adapter.Mian3Apapter;
import com.example.logindemo.list.bean.DataBean2;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//三級
public class Main4Activity extends AppCompatActivity {

    @BindView(R.id.rlv4)
    RecyclerView mRlv4;
    private Main4Adapter apapter;
    private List<DataBean2.ChildsBeanXX.ChildsBeanX> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);
        initView();
    }
    private void initView() {
        mRlv4.setLayoutManager(new LinearLayoutManager(this));
        mRlv4.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//        DataBean2.ChildsBeanXX childsBeanXX = list.get(position);
        apapter = new Main4Adapter(list,this);
        mRlv4.setAdapter(apapter);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getData(List<DataBean2.ChildsBeanXX.ChildsBeanX> childs){
        if (childs!=null){
            list = childs;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
