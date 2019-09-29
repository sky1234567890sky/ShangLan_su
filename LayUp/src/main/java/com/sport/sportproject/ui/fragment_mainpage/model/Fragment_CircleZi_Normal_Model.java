package com.sport.sportproject.ui.fragment_mainpage.model;

import com.sport.sportproject.base.BaseObservable;
import com.sport.sportproject.base.PublicModel;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.LoadConfig;
import com.sport.sportproject.interfaces.NetPort;
import com.sport.sportproject.interfaces.Params;
public class Fragment_CircleZi_Normal_Model implements PublicModel {
    @Override
    public void getData(PublicView view, int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                int load = (int) objects[0];
                if (load == LoadConfig.NOLOADMORE) {
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getCircleNormal(), view, type, load);
                } else if (load == LoadConfig.LOADMORE) {
                    String create_at = (String) objects[1];
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getCircleMore(create_at), view, type, load);
                }
                break;

            case Params.REQUEST_TWO:
                int load1 = (int) objects[0];
                if (load1 == LoadConfig.NOLOADMORE) {
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getCircleVideo(), view, type, load1);
                } else if (load1 == LoadConfig.LOADMORE) {
                    String create_at = (String) objects[1];
                    BaseObservable.getInstance()
                            .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getCircleMore(create_at), view, type, load1);
                }
                break;
        }
    }
}
