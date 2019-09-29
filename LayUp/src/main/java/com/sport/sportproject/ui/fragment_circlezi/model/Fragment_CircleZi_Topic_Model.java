package com.sport.sportproject.ui.fragment_circlezi.model;

import com.sport.sportproject.base.BaseObservable;
import com.sport.sportproject.base.PublicModel;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.NetPort;
import com.sport.sportproject.interfaces.Params;

/*
 *   梨花带雨,我见优伶  
 *      2019/4/25        
 */
public class Fragment_CircleZi_Topic_Model implements PublicModel {
    @Override
    public void getData(PublicView view, int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                .getCircleTopic(),view,type);
                break;
        }
    }
}
