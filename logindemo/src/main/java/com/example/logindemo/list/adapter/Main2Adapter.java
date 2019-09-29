package com.example.logindemo.list.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.logindemo.R;
import com.example.logindemo.list.Main3Activity;
import com.example.logindemo.list.bean.DataBean2;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 华为 on 2019/7/23.
 */

public class Main2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<DataBean2.ChildsBeanXX> list;
    private Context context;
    private DataBean2 dataBean2;

    public Main2Adapter(List<DataBean2.ChildsBeanXX> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        context = parent.getContext();
        vh = new ViewHolder1(View.inflate(context, R.layout.item_one, null));
        return vh;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        ViewHolder1 vh = (ViewHolder1) holder;
        final DataBean2.ChildsBeanXX childsBeanXX = list.get(position);
        List<DataBean2.ChildsBeanXX> childs = dataBean2.getChilds();
//        int i = childs.size() * 4 + 16 * 4 + 8 * childs.size() * 4;//總的
        int in = 0;
        for (int j = 0; j < list.size(); j++) {
            List<DataBean2.ChildsBeanXX.ChildsBeanX> childs1 = childs.get(j).getChilds();
            for (int k = 0; k < childs1.size(); k++) {
                List<DataBean2.ChildsBeanXX.ChildsBeanX.ChildsBean> childs2 = childs1.get(k).getChilds();
                for (int l = 0; l < childs2.size(); l++) {
                    DataBean2.ChildsBeanXX.ChildsBeanX.ChildsBean childsBean = childs2.get(l);
                    int testNum = childsBean.getTestNum();
                    in+=testNum;
                }
            }
        }
        if (childsBeanXX!=null) {
            vh.mName.setText(childsBeanXX.getName());
            vh.mNumber.setText(0+"/"+in);
        }

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Main3Activity main3Activity = new Main3Activity(list,position);
                Intent intent = new Intent(context, Main3Activity.class);
                EventBus.getDefault().postSticky(list);
                context.startActivity(intent);
            }
        });
//        vh.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (myOnClication!=null){
//                    Intent intent = new Intent(context, Main3Activity.class);
////                    myOnClication.MyOnclications(position,list);
////                    EventBus.getDefault().postSticky();
//                    context.startActivity(intent);
//                }
//            }
//            @Override
//            public void onClick(View v) {
//                if (myOnClication!=null){
//                    myOnClication.MyOnclications(position,childsBeanXX);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if (!list.equals("")){
            return list.size();
        }
        return 0;
    }

    public void setDatas(DataBean2 dataBean2) {

        this.dataBean2 = dataBean2;
        notifyDataSetChanged();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView mName;
        @BindView(R.id.number)
        TextView mNumber;
        public ViewHolder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //点击事件
//    public static MyOnClication myOnClication;
//
//    public static void setMyOnClication(MyOnClication myOnClication) {
//        Main2Adapter.myOnClication = myOnClication;
//    }
//
//    public  interface MyOnClication {
//        void MyOnclications(int i , List<DataBean2.ChildsBeanXX> childsBeanXX);
//    }
}
