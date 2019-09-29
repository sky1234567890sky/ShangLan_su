package com.sport.sportproject.ui.fragment_data.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.sport.sportproject.R;
import com.sport.sportproject.bean.bean.data.RankInfo;
import com.sport.sportproject.utils.ScreenUtil;
import com.sport.sportproject.weight.TempRankInfo;

import java.util.List;

/*
 *   比赛排名
 */
class RankAdapter extends RecyclerView.Adapter{
    private final Context context;
    private final List<TempRankInfo> rankList;

    public RankAdapter(Context context, List<TempRankInfo> rankList) {

        this.context = context;
        this.rankList = rankList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.rank_adapter_layout, null));
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> data = rankList.get(position).data;
        if (position == 0 || position == 6)
            setData(position, 4, holder1.mRecyclerView1, data);
        else if (position == 1 || position == 5) setData(position, 2, holder1.mRecyclerView1, data);
        else if (position == 2 || position == 3 || position == 4)
            setData(position, 1, holder1.mRecyclerView1, data);
    }
    private void setData(int lineNum, int rowNum, RecyclerView pRecyclerView1, List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> pData) {
        if (lineNum == 1 || lineNum == 5)
            pRecyclerView1.addItemDecoration(new SpaceItemDecoration(ScreenUtil.getPxWidth(context) / 16));
        if (lineNum == 2 || lineNum == 4)
            pRecyclerView1.addItemDecoration(new SpaceItemDecoration(ScreenUtil.getPxWidth(context) * 3 / 16));
        if (lineNum == 3)
            pRecyclerView1.addItemDecoration(new SpaceItemDecoration(ScreenUtil.getPxWidth(context) / 4));
        GridLayoutManager manager = new GridLayoutManager(context, rowNum);
        pRecyclerView1.setLayoutManager(manager);
        RecyclerView.Adapter adapter;
        if (lineNum <= 3)
            adapter = new RankItemWestAdapter(context, pData, lineNum);
        else adapter = new RankItemEastAdapter(context, pData, lineNum);
        pRecyclerView1.setAdapter(adapter);
    }
    @Override
    public int getItemCount() {
        return rankList.size();
    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.right = space;
            outRect.left = space;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView1;

        public ViewHolder(View itemView) {
            super(itemView);
            mRecyclerView1 = itemView.findViewById(R.id.item_recyclerView1);
        }
    }
}
