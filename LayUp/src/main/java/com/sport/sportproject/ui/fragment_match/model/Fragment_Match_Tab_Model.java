package com.sport.sportproject.ui.fragment_match.model;

import com.sport.sportproject.base.BaseObservable;
import com.sport.sportproject.base.PublicModel;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.NetPort;
import com.sport.sportproject.interfaces.Params;

/**
 * Created by 华为 on 2019/7/22.
 */

public class Fragment_Match_Tab_Model implements PublicModel {

    @Override
    public void getData(PublicView view, int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:

                BaseObservable.getInstance().getNetMessage(BaseObservable.getInstance()
                        .getApiService("https://sport-data.dqdgame.com/")
                        .getMtchmaxmumData(), view, type);

                break;
        }
    }
}
