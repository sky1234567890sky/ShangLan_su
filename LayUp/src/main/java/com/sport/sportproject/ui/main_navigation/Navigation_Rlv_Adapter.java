package com.sport.sportproject.ui.main_navigation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.bean.bean.navigation.NavigationBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
public class Navigation_Rlv_Adapter extends RecyclerView.Adapter<Navigation_Rlv_Adapter.Navigation_Rlv_ViewHolder> {

    private ArrayList<NavigationBean.ModulesBean> navigationBeans;
    private Context context;

    public Navigation_Rlv_Adapter(ArrayList<NavigationBean.ModulesBean> navigationBeans) {
        this.navigationBeans = navigationBeans;
    }
    @NonNull
    @Override
    public Navigation_Rlv_Adapter.Navigation_Rlv_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new Navigation_Rlv_ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_navigation, null));
    }

    @Override
    public void onBindViewHolder(@NonNull Navigation_Rlv_Adapter.Navigation_Rlv_ViewHolder holder, final int position) {
        NavigationBean.ModulesBean modulesBean = navigationBeans.get(position);
        holder.mTvName.setText(modulesBean.getName());
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(context).load(modulesBean.getImage()).apply(options).into(holder.mIvImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scheme = navigationBeans.get(position).getScheme();
                if (!scheme.contains("url")) {
                    return;
                }
                String substring = scheme.substring(15, scheme.length());
                NavigationWebActivity.go2Activtiy(context,substring);

//                if ()

            }

        });
    }

    @Override
    public int getItemCount() {
        return navigationBeans != null ? navigationBeans.size() : 0;
    }

    class Navigation_Rlv_ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_image)
        ImageView mIvImage;
        @BindView(R.id.tv_name)
        TextView mTvName;

        public Navigation_Rlv_ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
