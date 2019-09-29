package com.sport.sportproject.interfaces;
import com.sport.sportproject.adapter.bean.INSBean;
import com.sport.sportproject.adapter.bean.JijieBean;
import com.sport.sportproject.adapter.bean.ZhuantiBean;
import com.sport.sportproject.bean.bean.data.DataSeasonBean;
import com.sport.sportproject.bean.bean.data.DataTabBean;
import com.sport.sportproject.bean.bean.mainpage.MainPageHotBean;
import com.sport.sportproject.bean.bean.mainpage.MainPageLiveBean;
import com.sport.sportproject.bean.bean.mainpage.MainPageNewsBean;
import com.sport.sportproject.bean.bean.mainpage.MainPageTabBean;
import com.sport.sportproject.bean.bean.mainpage.SectionsBean;
import com.sport.sportproject.bean.bean.navigation.NavigationBean;
import com.sport.sportproject.bean.bean.team.FavTeamBean;
import com.sport.sportproject.ui.activity_attention_team.CommitFavInfo;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleNormalBean;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleTabBean;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleTopicBean;
import com.sport.sportproject.ui.fragment_match.MatchMaxmumInterface;
import com.sport.sportproject.ui.fragment_match.bean.ImportantBean;
import com.sport.sportproject.ui.fragment_match.bean.LeagueBean;
import com.sport.sportproject.ui.fragment_match.bean.MatchName;
import java.util.ArrayList;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
public interface APIService {
    String startData = "http://sport-data.dqdgame.com/sd/biz/index";
// navigationBeans
    // 导航数据
    @GET(NetPort.NAVIGATION_DATA_PORT)
    Observable<NavigationBean> getNavigationData();

    // 首页 Tab 数据
    @GET(NetPort.MAINPAGE_TAB_DATA_PORT)
    Observable<MainPageTabBean> getMainPageTabData();
    // 首页 头条 数据
    @GET(NetPort.MAINPAGE_DATA_PORT)
    Observable<MainPageNewsBean> getNewsBean(@Path("id") int id);

    // 首页 头条 加载更多
    //https://bkbapi.dqdgame.com/app/tabs/android/1.json
    @GET("app/tabs/android/{id}.json?after=1555846215&page=4&mark=gif&version=150&from=tab_1")
    Observable<MainPageNewsBean> getLoadMore(@Path("id") int id, @QueryMap Map<String, String> map);

    // 首页 头条 刷新
    // https://bkbapi.dqdgame.com/app/tabs/android/1.json?action=fresh&mark=gif&version=150&from=tab_1
    @GET("app/tabs/android/{id}.json")
    Observable<MainPageNewsBean> getRefresh(@Path("id") int id, @QueryMap Map<String, String> map);

    // Hot热门
    @GET(NetPort.MAINPAGE_DATA_PORT)
    Observable<MainPageHotBean> getHotData(@Path("id") int id);

    // Hot热门更多
    @GET(NetPort.MAINPAGE_DATA_PORT)
    Observable<MainPageHotBean> getHotLoadMoreData(@Path("id") int id, @QueryMap Map<String, String> map);
    // 集结
    @GET(NetPort.MAINPAGE_DATA_PORT)
    Observable<JijieBean> getJijie(@Path("id") int id);
    // 集结加载更多
    @GET("app/tabs/android/{id}.json?after=1555931770&page=2&mark=gif&version=150&from=tab_11")
    Observable<JijieBean> getJiJieMoreData(@Path("id") int id, @QueryMap Map<String, String> map);

    // 集结刷新
    @GET("app/tabs/android/{id}.json?action=fresh&mark=gif&version=150&from=tab_11")
    Observable<JijieBean> getJiJieRefreshData(@Path("id") int id, @QueryMap Map<String, String> map);


    //Hot 刷新
    @GET(NetPort.MAINPAGE_DATA_PORT)
    Observable<MainPageHotBean> getHotRefresh(@Path("id") int id, @QueryMap Map<String, String> map);

    // 关注球队 数据
    @GET(NetPort.FAVTEAM_DATA_PORT)
    Observable<FavTeamBean> getTeamData(@HeaderMap Map<String, String> map);

    // 提交球队
    @POST(NetPort.COMMIT_TEAM_PORT)
    @FormUrlEncoded
    Observable<CommitFavInfo> CommitTeam(@HeaderMap Map<String, String> map, @Field("team_ids") String team_ids);

    // INS
    @GET(NetPort.INSPORT)
    Observable<INSBean> getIns(@Path("type") String type);

    // Ins加载更多
    @GET("app/tabs/{type}.json?kind=1&page=2&after=1555996186")
    Observable<INSBean> getInsMore(@Path("type") String type, @QueryMap Map<String, String> map);

    // Ins刷新
    @GET("app/tabs/{type}.json?kind=1&before=2019-04-23 23:32:39")
    Observable<INSBean> getInsRefresh(@Path("type") String type, @QueryMap Map<String, String> map);

    // 专题
    @GET(NetPort.ZHUANGTIPORT)
    Observable<ZhuantiBean> getZhuanti();

    // 头条直播
    @GET(NetPort.HEADLIVE)
    Observable<ArrayList<MainPageLiveBean>> getLiveData();

    /*
        圈子  Tab
         */
    @GET(NetPort.CIRCLE_TAB)
    Observable<CircleTabBean> getCircleTab();

    /**
     * 圈子 Topic 话题
     */
    @GET(NetPort.CIRCLE_TOPIC)
    Observable<CircleTopicBean> getCircleTopic();

    /**
     * 圈子 推荐 Video
     */
    @GET(NetPort.COMMENT)
    Observable<CircleNormalBean> getCircleNormal();

    /**
     * 圈子 Video
     */
    @GET(NetPort.CRICLE_VIDEO)
    Observable<CircleNormalBean> getCircleVideo();

    /**
     * 圈子 Video 更多
     */
    @GET("http://bkbapi.dqdgame.com/group/app/thread/videoList?before=1556191501&flag=group")
    Observable<CircleNormalBean> getCircleMore(@Query("date") String date);
    /**
     * 首页专题首页
     */
    @GET(NetPort.MAINPAGE_SECTIONS_)
    Observable<SectionsBean> getSectionsData(@Path("id") int id);
    /**
     * 数据 TabLayout
     */
    @GET(NetPort.DATA_TAB)
    Observable<DataTabBean> getDataTab();

    @GET()
    Observable<ArrayList<DataSeasonBean>> getSeason(@Url String url);

    /**
     * 比赛接口展示
     */
    //http://sport-data.dqdgame.com/sd/biz/index
    @GET(NetPort.MATCH_MAXMUM_DATA)
    Observable<MatchMaxmumInterface>getMtchmaxmumData();
    //https://bkbapi.dqdgame.com/data/tab/matchs/max/person?match_ids=[11528,11532,11579,11596,11607,11608,11609,11610,11619,11620]

    @GET(NetPort.MATCH_ITEM_NAME)
    Observable<MatchName> getMatchName();

    @GET()
    Observable<ImportantBean>getMatchImportant(@Url String url);

    @GET()
    Observable<LeagueBean>getMatchLeagueBean(@Url String url);

    @GET()
    Observable<FavTeamBean>getMatchFavor(@Url String url);
}
