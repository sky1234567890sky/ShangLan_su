package com.sport.sportproject.interfaces;
public interface NetPort {
    //https://bkbapi.dqdgame.com/v2/config/index_menu?mark=gif&platform=android&version=132&android-channel=website
    //比赛  https://bkbapi.dqdgame.com/
    String BASEURL = "https://bkbapi.dqdgame.com/";

    String SECTIONSBASEURL = "https://bkbapi.dqdgame.com/";

    String SPORTBASEURL = "https://sport-data.dqdgame.com/";
    /**
     * 导航数据接口
     */
    String NAVIGATION_DATA_PORT = "app/global/2/android.json?mark=gif&platform=android&version=132&android-channel=website";
    /*首页*/
    /**
     * 首页 Tab 数据接口
     */
    String MAINPAGE_TAB_DATA_PORT = "v2/config/index_menu?mark=gif&platform=android&version=150&android-channel=qq";
    /**
     * 首页 热门 数据接口
     */
    String MAINPAGE_DATA_PORT = "app/tabs/iphone/{id}.json?mark=gif&version=100";

    /**
     * 关注球队 数据接口
     */
    String FAVTEAM_DATA_PORT = "v2/league/favlists";

    /**
     * 提交球队接口
     */
    String COMMIT_TEAM_PORT = "v2/team/batch/follow";

    /**
     * Tab :INS
     */
    String INSPORT = "app/tabs/{type}.json?version=150";


    /**
     *  Tab :专题
     */
    String ZHUANGTIPORT = "app/tabs/android/classifications.json?version=150";

    /**
     * Tab : 头条直播详细
     */
    String HEADLIVE = "sd/biz/live/index?platform=iphone&version=100";

    /*
    *  圈子 Tab
    * */
    String CIRCLE_TAB = "group/app/thread/tabs";

    /**
     * 圈子 Topic
     */
    String CIRCLE_TOPIC = "group/app/topic/list";

    /**
     * 圈子 推荐 视频
     */
    String COMMENT = "group/app/thread/feedList";

    /**
     * 圈子 Video
     */
    String CRICLE_VIDEO = "group/app/thread/videoList";

    /**
     * 首页专题详细
     */
    String MAINPAGE_SECTIONS_ = "old/columns/{id}";

    /**
     * 数据 Tab
     */
    String DATA_TAB = "sd/biz/index";

    /**http://sport-data.dqdgame.com/sd/biz/index
     * 比赛借口
     */
    String MATCH_MAXMUM_DATA = "sd/biz/index";

    //比賽的名字接口
    String  MATCH_ITEM_NAME="data/tab/matchs/max/person?match_ids=[11528,11532,11579,11596,11607,11608,11609,11610,11619,11620]";


}
