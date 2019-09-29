package com.sport.sportproject.ui.fragment_data.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseApp;
import com.sport.sportproject.bean.bean.data.DataRankThreeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *   梨花带雨,我见优伶
 *      2019/5/7
 */
public class DataRankThreeAdapter extends RecyclerView.Adapter<DataRankThreeAdapter.DataRankThreeViewHolder> {
    private final ArrayList<DataRankThreeBean.ContentBeanX.RoundsBean.ContentBean.DataBeanX> dataBeanXES;

    public DataRankThreeAdapter(ArrayList<DataRankThreeBean.ContentBeanX.RoundsBean.ContentBean.DataBeanX> dataBeanXES) {
        this.dataBeanXES = dataBeanXES;
    }

    @NonNull
    @Override
    public DataRankThreeAdapter.DataRankThreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataRankThreeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datarank_three, null));
    }

    @Override
    public void onBindViewHolder(@NonNull DataRankThreeAdapter.DataRankThreeViewHolder holder, int position) {
        if (dataBeanXES != null) ;
        DataRankThreeBean.ContentBeanX.RoundsBean.ContentBean.DataBeanX dataBeanX = dataBeanXES.get(position);
        List<String> header = dataBeanX.getHeader();
        holder.mItemTvName.setText(dataBeanX.getName() != null ? dataBeanX.getName() : "空数据1");
        holder.mItemTvVictoryOrDefeat.setText(header != null ? header.get(0) : "空数据2");
        holder.mItemTvWinRate.setText(header != null ? header.get(1) : "空数据3");
        holder.mItemTvMarginPoints.setText(header != null ? header.get(2) : "空数据4");
        holder.mItemTvIntegral.setText(header != null ? header.get(3) : "空数据5");
        holder.mItemRlv.setLayoutManager(new LinearLayoutManager(BaseApp.getInstance()));
        DataRankThreeChickAdapter dataRankThreeChickAdapter = new DataRankThreeChickAdapter(dataBeanX.getData());
        holder.mItemRlv.setAdapter(dataRankThreeChickAdapter);
        dataRankThreeChickAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataBeanXES != null ? dataBeanXES.size() : 0;
    }

    class DataRankThreeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_tv_name)
        TextView mItemTvName;
        @BindView(R.id.item_tv_victory_or_defeat)
        TextView mItemTvVictoryOrDefeat;
        @BindView(R.id.item_tv_win_rate)
        TextView mItemTvWinRate;
        @BindView(R.id.item_tv_Margin_points)
        TextView mItemTvMarginPoints;
        @BindView(R.id.item_tv_integral)
        TextView mItemTvIntegral;
        @BindView(R.id.ll)
        LinearLayout mLl;
        @BindView(R.id.item_rlv)
        RecyclerView mItemRlv;

        public DataRankThreeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
