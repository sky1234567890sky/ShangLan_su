package com.example.logindemo.list.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.logindemo.R;
import com.example.logindemo.list.Main3Activity;
import com.example.logindemo.list.Main4Activity;
import com.example.logindemo.list.bean.DataBean2;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 华为 on 2019/7/23.
 */

public class Mian3Apapter extends RecyclerView.Adapter<Mian3Apapter.ViewHolder>{


    private final List<DataBean2.ChildsBeanXX> list;
    private final Main3Activity context;

    public Mian3Apapter(List<DataBean2.ChildsBeanXX> list, Main3Activity main3Activity) {

        this.list = list;
        this.context = main3Activity;
    }

    @NonNull
    @Override
    public Mian3Apapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_one, null);
        return new ViewHolder(inflate);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Mian3Apapter.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        DataBean2.ChildsBeanXX childsBeanXX = list.get(position);
        final List<DataBean2.ChildsBeanXX.ChildsBeanX> childs = childsBeanXX.getChilds();
        int in = 0;
        for (int i = 0; i < childs.size(); i++) {
            DataBean2.ChildsBeanXX.ChildsBeanX childsBeanX = childs.get(i);
            List<DataBean2.ChildsBeanXX.ChildsBeanX.ChildsBean> childs1 = childsBeanX.getChilds();
            for (int j = 0; j < childs1.size(); j++) {
                DataBean2.ChildsBeanXX.ChildsBeanX.ChildsBean childsBean = childs1.get(j);
                in += childsBean.getTestNum();
            }
        }
        if (list!=null) {
            vh.mName.setText(childsBeanXX.getName());
            vh.mNumber.setText(childsBeanXX.getLock()+ "/"+in);
        }

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main4Activity.class);
                EventBus.getDefault().postSticky(childs);
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
//        List<DataBean2.ChildsBeanXX.ChildsBeanX> list = childsBeanXX.getChilds();
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView mName;
        @BindView(R.id.number)
        TextView mNumber;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
