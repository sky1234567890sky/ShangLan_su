package com.sport.sportproject.bean.bean.data;

import java.util.List;

/*
 *   梨花带雨,我见优伶  
 *      2019/5/4        
 */
public class DataTeamBean {

    /**
     * template : team_ranking
     * content : {"header":["防守效率榜","数据"],"data":[{"rank":"1","value":"99.6","team_id":"1","team_name":"猛龙","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png"},{"rank":"2","value":"100.7","team_id":"7","team_name":"雄鹿","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCATv7wAAAs0EsJ4Tk683.png"},{"rank":"3","value":"101.3","team_id":"2","team_name":"凯尔特人","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsGAcTB9AAAzIXN3Q3Y524.png"},{"rank":"4","value":"103.2","team_id":"16","team_name":"火箭","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrr6Ae3A_AAAtr2JLoW4150.png"},{"rank":"5","value":"103.7","team_id":"5","team_name":"步行者","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCAYfafAAAlyoZIAtQ844.png"},{"rank":"6","value":"104.2","team_id":"3","team_name":"76人","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_G7eAFO_pAABFGVQtzWQ853.png"},{"rank":"7","value":"106.2","team_id":"18","team_name":"开拓者","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCAEwkyAAAoo3UMQ2Q443.png"},{"rank":"8","value":"108.3","team_id":"20","team_name":"爵士","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr-AMUt_AAA97iAG0g8899.png"},{"rank":"9","value":"109.9","team_id":"19","team_name":"雷霆","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCATc8cAAAuqQwJlww373.png"},{"rank":"10","value":"110.4","team_id":"24","team_name":"掘金","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCAHsWSAAAt9BkzJu0558.png"},{"rank":"11","value":"110.7","team_id":"17","team_name":"勇士","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png"},{"rank":"12","value":"111.5","team_id":"14","team_name":"魔术","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrr6Ac05HAAA8YzNpXIs701.png"},{"rank":"13","value":"113.1","team_id":"22","team_name":"马刺","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrr-ATfsKAAAcV4DfpCs159.png"},{"rank":"14","value":"115.7","team_id":"12","team_name":"篮网","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/35/ChM9m1vJUWOAJr4YAAAwPWpnJ_4428.png"},{"rank":"15","value":"120.2","team_id":"9","team_name":"活塞","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6ASbaPAABOr3cw7co043.png"},{"rank":"16","value":"120.5","team_id":"25","team_name":"快船","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/50/ChOlBlvT9_OAYMhBAABByPFIICQ711.png"}],"top":0,"end":0,"description":""}
     */

    private String template;
    private ContentBean content;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * header : ["防守效率榜","数据"]
         * data : [{"rank":"1","value":"99.6","team_id":"1","team_name":"猛龙","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png"},{"rank":"2","value":"100.7","team_id":"7","team_name":"雄鹿","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCATv7wAAAs0EsJ4Tk683.png"},{"rank":"3","value":"101.3","team_id":"2","team_name":"凯尔特人","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsGAcTB9AAAzIXN3Q3Y524.png"},{"rank":"4","value":"103.2","team_id":"16","team_name":"火箭","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrr6Ae3A_AAAtr2JLoW4150.png"},{"rank":"5","value":"103.7","team_id":"5","team_name":"步行者","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCAYfafAAAlyoZIAtQ844.png"},{"rank":"6","value":"104.2","team_id":"3","team_name":"76人","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_G7eAFO_pAABFGVQtzWQ853.png"},{"rank":"7","value":"106.2","team_id":"18","team_name":"开拓者","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCAEwkyAAAoo3UMQ2Q443.png"},{"rank":"8","value":"108.3","team_id":"20","team_name":"爵士","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr-AMUt_AAA97iAG0g8899.png"},{"rank":"9","value":"109.9","team_id":"19","team_name":"雷霆","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrsCATc8cAAAuqQwJlww373.png"},{"rank":"10","value":"110.4","team_id":"24","team_name":"掘金","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrsCAHsWSAAAt9BkzJu0558.png"},{"rank":"11","value":"110.7","team_id":"17","team_name":"勇士","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png"},{"rank":"12","value":"111.5","team_id":"14","team_name":"魔术","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrr6Ac05HAAA8YzNpXIs701.png"},{"rank":"13","value":"113.1","team_id":"22","team_name":"马刺","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChM9m1vGrr-ATfsKAAAcV4DfpCs159.png"},{"rank":"14","value":"115.7","team_id":"12","team_name":"篮网","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/35/ChM9m1vJUWOAJr4YAAAwPWpnJ_4428.png"},{"rank":"15","value":"120.2","team_id":"9","team_name":"活塞","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6ASbaPAABOr3cw7co043.png"},{"rank":"16","value":"120.5","team_id":"25","team_name":"快船","team_logo":"http://img1.dqdgame.com/fastdfs/M00/00/50/ChOlBlvT9_OAYMhBAABByPFIICQ711.png"}]
         * top : 0
         * end : 0
         * description :
         */

        private int top;
        private int end;
        private String description;
        private List<String> header;
        private List<DataBean> data;

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getHeader() {
            return header;
        }

        public void setHeader(List<String> header) {
            this.header = header;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * rank : 1
             * value : 99.6
             * team_id : 1
             * team_name : 猛龙
             * team_logo : http://img1.dqdgame.com/fastdfs/M00/00/04/ChM9m1u_HxmAXSW6AAA7haimyQ4555.png
             */

            private String rank;
            private String value;
            private String team_id;
            private String team_name;
            private String team_logo;

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getTeam_id() {
                return team_id;
            }

            public void setTeam_id(String team_id) {
                this.team_id = team_id;
            }

            public String getTeam_name() {
                return team_name;
            }

            public void setTeam_name(String team_name) {
                this.team_name = team_name;
            }

            public String getTeam_logo() {
                return team_logo;
            }

            public void setTeam_logo(String team_logo) {
                this.team_logo = team_logo;
            }
        }
    }
}
