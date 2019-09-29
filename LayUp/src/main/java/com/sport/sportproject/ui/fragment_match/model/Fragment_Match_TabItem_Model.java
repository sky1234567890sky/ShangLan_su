package com.sport.sportproject.ui.fragment_match.model;

import com.sport.sportproject.base.BaseObservable;
import com.sport.sportproject.base.PublicModel;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.NetPort;
import com.sport.sportproject.interfaces.Params;

/**
 * 比賽復用的解析
 * Created by 华为 on 2019/7/22.
 */

public class Fragment_Match_TabItem_Model implements PublicModel {
    // //https://bkbapi.dqdgame.com/data/tab/matchs/max/person?match_ids=[11528,11532,11579,11596,11607,11608,11609,11610,11619,11620]
    @Override
    public void getData(PublicView view, int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                .getMatchName(), view, type);
                break;
                //favor
            case Params.REQUEST_TWO:
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                .getMatchFavor((String) objects[0]), view, type);
                break;
                //important
            case Params.REQUEST_THREE:
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                .getMatchImportant((String) objects[0]), view, type);
                break;
                //league
            case Params.REQUEST_FOUR:
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                .getMatchLeagueBean((String) objects[0]), view, type);
                break;
        }
    }
}
