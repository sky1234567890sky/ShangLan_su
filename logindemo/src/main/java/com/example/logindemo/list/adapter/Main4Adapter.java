package com.example.logindemo.list.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.logindemo.R;
import com.example.logindemo.list.Main4Activity;
import com.example.logindemo.list.bean.DataBean2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 华为 on 2019/7/23.
 */

public class Main4Adapter extends RecyclerView.Adapter<Main4Adapter.ViewHolder> {
    private final List<DataBean2.ChildsBeanXX.ChildsBeanX> list;
    private final Main4Activity context;

    public Main4Adapter(List<DataBean2.ChildsBeanXX.ChildsBeanX> list, Main4Activity context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Main4Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.item_one, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Main4Adapter.ViewHolder holder, int position) {
        DataBean2.ChildsBeanXX.ChildsBeanX childsBeanX = list.get(position);
        holder.mName.setText(childsBeanX.getName());
        holder.mNumber.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
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
