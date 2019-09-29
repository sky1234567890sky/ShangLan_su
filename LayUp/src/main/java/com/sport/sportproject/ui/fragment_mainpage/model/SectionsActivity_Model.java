package com.sport.sportproject.ui.fragment_mainpage.model;

import com.sport.sportproject.base.BaseObservable;
import com.sport.sportproject.base.PublicModel;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.NetPort;
import com.sport.sportproject.interfaces.Params;
public class SectionsActivity_Model implements PublicModel {
    @Override
    public void getData(PublicView view, int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                int id = (int) objects[0];
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.SECTIONSBASEURL)
                                .getSectionsData(id), view, type);
                break;
        }
    }
}
