package com.sport.sportproject.ui.fragment_match.bean;

import java.util.List;

/**
 * Created by 华为 on 2019/7/5.
 */
//重要
public class ImportantBean {

    /**
     * list : [{"relate_type":"match","relate_id":"11523","match_id":"11523","team_A_id":"24","team_A_name":"掘金","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCAHsWSAAAt9BkzJu0558.png","team_B_id":"18","team_B_name":"开拓者","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCAEwkyAAAoo3UMQ2Q443.png","start_play":"2019-05-12 19:30:00","status":"Played","fs_A":"96","fs_B":"100","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1557703024","playoff_fs_A":"3","playoff_fs_B":"4"},{"relate_type":"match","relate_id":"11517","match_id":"11517","team_A_id":"1","team_A_name":"猛龙","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","team_B_id":"3","team_B_name":"76人","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_G7eAFO_pAABFGVQtzWQ853.png","start_play":"2019-05-12 23:00:00","status":"Played","fs_A":"92","fs_B":"90","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1557712860","playoff_fs_A":"4","playoff_fs_B":"3"},{"relate_type":"match","relate_id":"11525","match_id":"11525","team_A_id":"17","team_A_name":"勇士","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png","team_B_id":"18","team_B_name":"开拓者","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCAEwkyAAAoo3UMQ2Q443.png","start_play":"2019-05-15 01:00:00","status":"Played","fs_A":"116","fs_B":"94","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1557892860","playoff_fs_A":"1","playoff_fs_B":"0"},{"relate_type":"match","relate_id":"11529","match_id":"11529","team_A_id":"7","team_A_name":"雄鹿","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCATv7wAAAs0EsJ4Tk683.png","team_B_id":"1","team_B_name":"猛龙","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","start_play":"2019-05-16 00:30:00","status":"Played","fs_A":"108","fs_B":"100","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1557979259","playoff_fs_A":"1","playoff_fs_B":"0"},{"relate_type":"match","relate_id":"11526","match_id":"11526","team_A_id":"17","team_A_name":"勇士","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png","team_B_id":"18","team_B_name":"开拓者","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCAEwkyAAAoo3UMQ2Q443.png","start_play":"2019-05-17 01:00:00","status":"Played","fs_A":"114","fs_B":"111","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1558064159","playoff_fs_A":"2","playoff_fs_B":"0"},{"relate_type":"match","relate_id":"11530","match_id":"11530","team_A_id":"7","team_A_name":"雄鹿","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCATv7wAAAs0EsJ4Tk683.png","team_B_id":"1","team_B_name":"猛龙","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","start_play":"2019-05-18 00:30:00","status":"Played","fs_A":"125","fs_B":"103","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1558152067","playoff_fs_A":"2","playoff_fs_B":"0"},{"relate_type":"match","relate_id":"11527","match_id":"11527","team_A_id":"18","team_A_name":"开拓者","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCAEwkyAAAoo3UMQ2Q443.png","team_B_id":"17","team_B_name":"勇士","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png","start_play":"2019-05-19 01:00:00","status":"Played","fs_A":"99","fs_B":"110","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1558238465","playoff_fs_A":"0","playoff_fs_B":"3"},{"relate_type":"match","relate_id":"11531","match_id":"11531","team_A_id":"1","team_A_name":"猛龙","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","team_B_id":"7","team_B_name":"雄鹿","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCATv7wAAAs0EsJ4Tk683.png","start_play":"2019-05-19 23:00:00","status":"Played","fs_A":"118","fs_B":"112","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1558318656","playoff_fs_A":"1","playoff_fs_B":"2"},{"relate_type":"match","relate_id":"11528","match_id":"11528","team_A_id":"18","team_A_name":"开拓者","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCAEwkyAAAoo3UMQ2Q443.png","team_B_id":"17","team_B_name":"勇士","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png","start_play":"2019-05-21 01:00:00","status":"Played","fs_A":"117","fs_B":"119","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1558411263","playoff_fs_A":"0","playoff_fs_B":"4"},{"relate_type":"match","relate_id":"11532","match_id":"11532","team_A_id":"1","team_A_name":"猛龙","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","team_B_id":"7","team_B_name":"雄鹿","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCATv7wAAAs0EsJ4Tk683.png","start_play":"2019-05-22 00:30:00","status":"Played","fs_A":"120","fs_B":"102","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1558497655","playoff_fs_A":"2","playoff_fs_B":"2"},{"relate_type":"match","relate_id":"11579","match_id":"11579","team_A_id":"7","team_A_name":"雄鹿","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCATv7wAAAs0EsJ4Tk683.png","team_B_id":"1","team_B_name":"猛龙","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","start_play":"2019-05-24 00:30:00","status":"Played","fs_A":"99","fs_B":"105","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1558670466","playoff_fs_A":"2","playoff_fs_B":"3"},{"relate_type":"match","relate_id":"11596","match_id":"11596","team_A_id":"1","team_A_name":"猛龙","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","team_B_id":"7","team_B_name":"雄鹿","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCATv7wAAAs0EsJ4Tk683.png","start_play":"2019-05-26 00:30:00","status":"Played","fs_A":"100","fs_B":"94","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 季后赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA季后赛","timestamp":"1558843264","playoff_fs_A":"4","playoff_fs_B":"2"},{"relate_type":"match","relate_id":"11607","match_id":"11607","team_A_id":"1","team_A_name":"猛龙","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","team_B_id":"17","team_B_name":"勇士","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png","start_play":"2019-05-31 01:00:00","status":"Played","fs_A":"118","fs_B":"109","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 总决赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA总决赛","timestamp":"1559275284","playoff_fs_A":"1","playoff_fs_B":"0"},{"relate_type":"match","relate_id":"11608","match_id":"11608","team_A_id":"1","team_A_name":"猛龙","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","team_B_id":"17","team_B_name":"勇士","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png","start_play":"2019-06-03 00:00:00","status":"Played","fs_A":"104","fs_B":"109","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 总决赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA总决赛","timestamp":"1559530863","playoff_fs_A":"1","playoff_fs_B":"1"},{"relate_type":"match","relate_id":"11609","match_id":"11609","team_A_id":"17","team_A_name":"勇士","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png","team_B_id":"1","team_B_name":"猛龙","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","start_play":"2019-06-06 01:00:00","status":"Played","fs_A":"109","fs_B":"123","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 总决赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA总决赛","timestamp":"1559793669","playoff_fs_A":"1","playoff_fs_B":"2"},{"relate_type":"match","relate_id":"11610","match_id":"11610","team_A_id":"17","team_A_name":"勇士","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png","team_B_id":"1","team_B_name":"猛龙","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","start_play":"2019-06-08 01:00:00","status":"Played","fs_A":"92","fs_B":"105","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 总决赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA总决赛","timestamp":"1559966464","playoff_fs_A":"1","playoff_fs_B":"3"},{"relate_type":"match","relate_id":"11619","match_id":"11619","team_A_id":"1","team_A_name":"猛龙","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","team_B_id":"17","team_B_name":"勇士","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png","start_play":"2019-06-11 01:00:00","status":"Played","fs_A":"105","fs_B":"106","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 总决赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA总决赛","timestamp":"1560225665","playoff_fs_A":"3","playoff_fs_B":"2"},{"relate_type":"match","relate_id":"11620","match_id":"11620","team_A_id":"17","team_A_name":"勇士","team_A_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png","team_B_id":"1","team_B_name":"猛龙","team_B_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png","start_play":"2019-06-14 01:00:00","status":"Played","fs_A":"110","fs_B":"114","gameweek":"","minute":"0","second":"0","period":"FT","team_A_wins":"","team_B_wins":"","competition_id":"1","competition_name":"NBA","round_name":"NBA 总决赛","highlight":false,"TVList":"","tv_source":"","videoFlag":true,"webLivingFlag":false,"transfer":"1","match_title":"NBA总决赛","timestamp":"1560484865","playoff_fs_A":"2","playoff_fs_B":"4"}]
     * prevDate : 2019-05-12 00:00:00prev
     * nextDate :
     * finishFlag : true
     */

    private String prevDate;
    private String nextDate;
    private boolean finishFlag;
    private List<ListBean> list;

    public String getPrevDate() {
        return prevDate;
    }

    public void setPrevDate(String prevDate) {
        this.prevDate = prevDate;
    }

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }

    public boolean isFinishFlag() {
        return finishFlag;
    }

    public void setFinishFlag(boolean finishFlag) {
        this.finishFlag = finishFlag;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * relate_type : match
         * relate_id : 11523
         * match_id : 11523
         * team_A_id : 24
         * team_A_name : 掘金
         * team_A_logo : http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCAHsWSAAAt9BkzJu0558.png
         * team_B_id : 18
         * team_B_name : 开拓者
         * team_B_logo : http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCAEwkyAAAoo3UMQ2Q443.png
         * start_play : 2019-05-12 19:30:00
         * status : Played
         * fs_A : 96
         * fs_B : 100
         * gameweek :
         * minute : 0
         * second : 0
         * period : FT
         * team_A_wins :
         * team_B_wins :
         * competition_id : 1
         * competition_name : NBA
         * round_name : NBA 季后赛
         * highlight : false
         * TVList :
         * tv_source :
         * videoFlag : true
         * webLivingFlag : false
         * transfer : 1
         * match_title : NBA季后赛
         * timestamp : 1557703024
         * playoff_fs_A : 3
         * playoff_fs_B : 4
         */

        private String relate_type;
        private String relate_id;
        private String match_id;
        private String team_A_id;
        private String team_A_name;
        private String team_A_logo;
        private String team_B_id;
        private String team_B_name;
        private String team_B_logo;
        private String start_play;
        private String status;
        private String fs_A;
        private String fs_B;
        private String gameweek;
        private String minute;
        private String second;
        private String period;
        private String team_A_wins;
        private String team_B_wins;
        private String competition_id;
        private String competition_name;
        private String round_name;
        private boolean highlight;
        private String TVList;
        private String tv_source;
        private boolean videoFlag;
        private boolean webLivingFlag;
        private String transfer;
        private String match_title;
        private String timestamp;
        private String playoff_fs_A;
        private String playoff_fs_B;

        public String getRelate_type() {
            return relate_type;
        }

        public void setRelate_type(String relate_type) {
            this.relate_type = relate_type;
        }

        public String getRelate_id() {
            return relate_id;
        }

        public void setRelate_id(String relate_id) {
            this.relate_id = relate_id;
        }

        public String getMatch_id() {
            return match_id;
        }

        public void setMatch_id(String match_id) {
            this.match_id = match_id;
        }

        public String getTeam_A_id() {
            return team_A_id;
        }

        public void setTeam_A_id(String team_A_id) {
            this.team_A_id = team_A_id;
        }

        public String getTeam_A_name() {
            return team_A_name;
        }

        public void setTeam_A_name(String team_A_name) {
            this.team_A_name = team_A_name;
        }

        public String getTeam_A_logo() {
            return team_A_logo;
        }

        public void setTeam_A_logo(String team_A_logo) {
            this.team_A_logo = team_A_logo;
        }

        public String getTeam_B_id() {
            return team_B_id;
        }

        public void setTeam_B_id(String team_B_id) {
            this.team_B_id = team_B_id;
        }

        public String getTeam_B_name() {
            return team_B_name;
        }

        public void setTeam_B_name(String team_B_name) {
            this.team_B_name = team_B_name;
        }

        public String getTeam_B_logo() {
            return team_B_logo;
        }

        public void setTeam_B_logo(String team_B_logo) {
            this.team_B_logo = team_B_logo;
        }

        public String getStart_play() {
            return start_play;
        }

        public void setStart_play(String start_play) {
            this.start_play = start_play;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFs_A() {
            return fs_A;
        }

        public void setFs_A(String fs_A) {
            this.fs_A = fs_A;
        }

        public String getFs_B() {
            return fs_B;
        }

        public void setFs_B(String fs_B) {
            this.fs_B = fs_B;
        }

        public String getGameweek() {
            return gameweek;
        }

        public void setGameweek(String gameweek) {
            this.gameweek = gameweek;
        }

        public String getMinute() {
            return minute;
        }

        public void setMinute(String minute) {
            this.minute = minute;
        }

        public String getSecond() {
            return second;
        }

        public void setSecond(String second) {
            this.second = second;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getTeam_A_wins() {
            return team_A_wins;
        }

        public void setTeam_A_wins(String team_A_wins) {
            this.team_A_wins = team_A_wins;
        }

        public String getTeam_B_wins() {
            return team_B_wins;
        }

        public void setTeam_B_wins(String team_B_wins) {
            this.team_B_wins = team_B_wins;
        }

        public String getCompetition_id() {
            return competition_id;
        }

        public void setCompetition_id(String competition_id) {
            this.competition_id = competition_id;
        }

        public String getCompetition_name() {
            return competition_name;
        }

        public void setCompetition_name(String competition_name) {
            this.competition_name = competition_name;
        }

        public String getRound_name() {
            return round_name;
        }

        public void setRound_name(String round_name) {
            this.round_name = round_name;
        }

        public boolean isHighlight() {
            return highlight;
        }

        public void setHighlight(boolean highlight) {
            this.highlight = highlight;
        }

        public String getTVList() {
            return TVList;
        }

        public void setTVList(String TVList) {
            this.TVList = TVList;
        }

        public String getTv_source() {
            return tv_source;
        }

        public void setTv_source(String tv_source) {
            this.tv_source = tv_source;
        }

        public boolean isVideoFlag() {
            return videoFlag;
        }

        public void setVideoFlag(boolean videoFlag) {
            this.videoFlag = videoFlag;
        }

        public boolean isWebLivingFlag() {
            return webLivingFlag;
        }

        public void setWebLivingFlag(boolean webLivingFlag) {
            this.webLivingFlag = webLivingFlag;
        }

        public String getTransfer() {
            return transfer;
        }

        public void setTransfer(String transfer) {
            this.transfer = transfer;
        }

        public String getMatch_title() {
            return match_title;
        }

        public void setMatch_title(String match_title) {
            this.match_title = match_title;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getPlayoff_fs_A() {
            return playoff_fs_A;
        }

        public void setPlayoff_fs_A(String playoff_fs_A) {
            this.playoff_fs_A = playoff_fs_A;
        }

        public String getPlayoff_fs_B() {
            return playoff_fs_B;
        }

        public void setPlayoff_fs_B(String playoff_fs_B) {
            this.playoff_fs_B = playoff_fs_B;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "relate_type='" + relate_type + '\'' +
                    ", relate_id='" + relate_id + '\'' +
                    ", match_id='" + match_id + '\'' +
                    ", team_A_id='" + team_A_id + '\'' +
                    ", team_A_name='" + team_A_name + '\'' +
                    ", team_A_logo='" + team_A_logo + '\'' +
                    ", team_B_id='" + team_B_id + '\'' +
                    ", team_B_name='" + team_B_name + '\'' +
                    ", team_B_logo='" + team_B_logo + '\'' +
                    ", start_play='" + start_play + '\'' +
                    ", status='" + status + '\'' +
                    ", fs_A='" + fs_A + '\'' +
                    ", fs_B='" + fs_B + '\'' +
                    ", gameweek='" + gameweek + '\'' +
                    ", minute='" + minute + '\'' +
                    ", second='" + second + '\'' +
                    ", period='" + period + '\'' +
                    ", team_A_wins='" + team_A_wins + '\'' +
                    ", team_B_wins='" + team_B_wins + '\'' +
                    ", competition_id='" + competition_id + '\'' +
                    ", competition_name='" + competition_name + '\'' +
                    ", round_name='" + round_name + '\'' +
                    ", highlight=" + highlight +
                    ", TVList='" + TVList + '\'' +
                    ", tv_source='" + tv_source + '\'' +
                    ", videoFlag=" + videoFlag +
                    ", webLivingFlag=" + webLivingFlag +
                    ", transfer='" + transfer + '\'' +
                    ", match_title='" + match_title + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    ", playoff_fs_A='" + playoff_fs_A + '\'' +
                    ", playoff_fs_B='" + playoff_fs_B + '\'' +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "ImportantBean{" +
                "prevDate='" + prevDate + '\'' +
                ", nextDate='" + nextDate + '\'' +
                ", finishFlag=" + finishFlag +
                ", list=" + list +
                '}';
    }
}
