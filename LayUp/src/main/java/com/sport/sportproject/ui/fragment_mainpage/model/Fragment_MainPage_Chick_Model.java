package com.sport.sportproject.ui.fragment_mainpage.model;

import android.util.Log;
import com.sport.sportproject.base.BaseObservable;
import com.sport.sportproject.base.PublicModel;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.LoadConfig;
import com.sport.sportproject.interfaces.NetPort;
import com.sport.sportproject.interfaces.Params;
import java.util.HashMap;
public class Fragment_MainPage_Chick_Model implements PublicModel {
    private static final String TAG = "Fragment_MainPage_Chick";
    private int id;
    @Override
    public void getData(PublicView view, int type, Object... objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                id = (int) objects[0];
                int load = (int) objects[1];
                if (load == LoadConfig.NOLOADMORE) {
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getNewsBean(id), view, type, load);
                } else if (load == LoadConfig.LOADMORE) {
                    int page = (int) objects[2];
                    String min = (String) objects[3];
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getLoadMore(id, getLoadMoreMap(min, page)), view, type, load);
                } else if (load == LoadConfig.REFRESH) {
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getRefresh(id, getRefreshMap()), view, type, load);
                }
                break;

            case Params.REQUEST_TWO:
                id = (int) objects[0];
                int load1 = (int) objects[1];
                if (load1 == LoadConfig.NOLOADMORE) {
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getJijie(id), view, type, load1);
                } else if (load1 == LoadConfig.LOADMORE) {
                    int page = (int) objects[2];
                    String min = (String) objects[3];
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getJiJieMoreData(id, getLoadMoreMap(min, page)), view, type, load1);
                } else if (load1 == LoadConfig.REFRESH) {
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getJiJieRefreshData(id, getRefreshMap()), view, type, load1);
                }

                break;
            case Params.REQUEST_THREE:
                int load2 = (int) objects[1];
                String types = (String) objects[0];
                if (load2 == LoadConfig.NOLOADMORE) {
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getIns(types), view, type, load2);
                } else if (load2 == LoadConfig.LOADMORE) {
                    int page = (int) objects[2];
                    long min = (long) objects[3];
                    String s = String.valueOf(min);
                    HashMap<String, String> insmap = new HashMap<>();
                    insmap.put("kind", "1");
                    insmap.put("page", page + "");
                    insmap.put("after", s);
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getInsMore(types, insmap), view, type, load2);

                    Log.d(TAG, "onLoadMore: " + "wall ++++++++++++++++++++++");

                } else if (load2 == LoadConfig.REFRESH) {
                    HashMap<String, String> insrefresh = new HashMap<>();
                    insrefresh.put("kind", "1");
                    insrefresh.put("before", "2019-04-23 23:32:39");
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getInsRefresh(types, insrefresh), view, type, load2);
                }
                break;

            case Params.REQUEST_FOUR:
                id = (int) objects[0];
                int load4 = (int) objects[1];
                BaseObservable.getInstance()
                        .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                .getZhuanti(), view, type, load4);
                break;
            case Params.REQUEST_HEAD_LIVE:
                id = (int) objects[0];
                int load5 = (int) objects[1];
                BaseObservable.getInstance()
                        .getNetMessage(BaseObservable.getInstance().getApiService(NetPort.SPORTBASEURL)
                                .getLiveData(), view, type, load5);
                break;

            case Params.REQUEST_HOT_DATA:
                id = (int) objects[0];
                int load3 = (int) objects[1];
                if (load3 == LoadConfig.NOLOADMORE) {
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getHotData(id), view, type, load3);
                } else if (load3 == LoadConfig.LOADMORE) {
                    int page1 = (int) objects[2];
                    String min = (String) objects[3];
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getHotLoadMoreData(id, getLoadMoreMap(min, page1)), view, type, load3);
                } else {
                    BaseObservable.getInstance()
                            .getNetMessages(BaseObservable.getInstance().getApiService(NetPort.BASEURL)
                                    .getHotRefresh(id, getRefreshMap()), view, type, load3);
                }
                break;
        }
    }
    private HashMap<String, String> getRefreshMap() {
        HashMap<String, String> MapRefresh = new HashMap<>();
        MapRefresh.put("action", "fresh");
        MapRefresh.put("mark", "gif");
        MapRefresh.put("version", "150");
        MapRefresh.put("from", "tab_" + id);
        return MapRefresh;
    }
    private HashMap<String, String> getLoadMoreMap(String min, int page) {
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("after", min);
        map2.put("page", page + "");
        map2.put("mark", "gif");
        map2.put("version", "150");
        map2.put("from", "tab_" + id);
        return map2;
    }
}
