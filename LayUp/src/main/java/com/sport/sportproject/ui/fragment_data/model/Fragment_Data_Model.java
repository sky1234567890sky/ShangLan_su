package com.sport.sportproject.ui.fragment_data.model;
import com.sport.sportproject.base.BaseObservable;
import com.sport.sportproject.base.PublicModel;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.NetPort;
import com.sport.sportproject.interfaces.Params;
public class Fragment_Data_Model implements PublicModel {

    @Override
    public void getData(PublicView view, int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.SPORTBASEURL)
                                .getDataTab(), view, type);
                break;
            case Params.REQUEST_TWO:
                String url = (String) objects[0];
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService()
                                .getSeason(url),view,type);
                break;
        }
    }
}
