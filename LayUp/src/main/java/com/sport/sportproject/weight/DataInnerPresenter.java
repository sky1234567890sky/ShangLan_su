package com.sport.sportproject.weight;

import com.sport.sportproject.bean.bean.data.RankInfo;

import java.util.ArrayList;
import java.util.List;

public class DataInnerPresenter {
    public List<TempRankInfo> getRankList(RankInfo.ContentBeanX.RoundsBean pRoundsBean) {
        List<TempRankInfo> tempRankInfoList = new ArrayList<>();
        List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> data = pRoundsBean.getContent().getData();
        List<RankInfo.ContentBeanX.RoundsBean.ContentBean.DataBean> temp1;
        temp1 = new ArrayList<>();
        temp1.add(data.get(7));
        temp1.add(data.get(8));
        temp1.add(data.get(9));
        temp1.add(data.get(10));
        TempRankInfo tempRankInfo1 = new TempRankInfo();
        tempRankInfo1.data = temp1;
        tempRankInfoList.add(tempRankInfo1);
        temp1 = new ArrayList<>();
        temp1.add(data.get(3));
        temp1.add(data.get(4));
        TempRankInfo tempRankInfo2 = new TempRankInfo();
        tempRankInfo2.data = temp1;
        tempRankInfoList.add(tempRankInfo2);
        temp1 = new ArrayList<>();
        temp1.add(data.get(1));
        TempRankInfo tempRankInfo3 = new TempRankInfo();
        tempRankInfo3.data = temp1;
        tempRankInfoList.add(tempRankInfo3);
        temp1 = new ArrayList<>();
        temp1.add(data.get(0));
        TempRankInfo tempRankInfo4 = new TempRankInfo();
        tempRankInfo4.data = temp1;
        tempRankInfoList.add(tempRankInfo4);
        temp1 = new ArrayList<>();
        temp1.add(data.get(2));
        TempRankInfo tempRankInfo5 = new TempRankInfo();
        tempRankInfo5.data = temp1;
        tempRankInfoList.add(tempRankInfo5);
        temp1 = new ArrayList<>();
        temp1.add(data.get(5));
        temp1.add(data.get(6));
        TempRankInfo tempRankInfo6 = new TempRankInfo();
        tempRankInfo6.data = temp1;
        tempRankInfoList.add(tempRankInfo6);
        temp1 = new ArrayList<>();
        temp1.add(data.get(11));
        temp1.add(data.get(12));
        temp1.add(data.get(13));
        temp1.add(data.get(14));
        TempRankInfo tempRankInfo7 = new TempRankInfo();
        tempRankInfo7.data = temp1;
        tempRankInfoList.add(tempRankInfo7);
        return tempRankInfoList;
    }
}
