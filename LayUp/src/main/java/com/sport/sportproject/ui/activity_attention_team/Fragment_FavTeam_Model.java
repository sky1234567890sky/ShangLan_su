package com.sport.sportproject.ui.activity_attention_team;

import com.sport.sportproject.base.BaseObservable;
import com.sport.sportproject.base.PublicModel;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.NetPort;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.utils.NetHeaders;

/*
 *   梨花带雨,我见优伶  
 *      2019/4/19        
 */
public class Fragment_FavTeam_Model implements PublicModel {
    @Override
    public void getData(PublicView view, int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                .getTeamData(NetHeaders.getHeadMap()), view, type);
                break;
            case Params.REQUEST_TWO:
                String teams = (String) objects[0];
                String substring = teams.substring(0, teams.length() - 1);
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                .CommitTeam(NetHeaders.getHeadMap(), substring), view, type);
                break;
        }
    }
}
