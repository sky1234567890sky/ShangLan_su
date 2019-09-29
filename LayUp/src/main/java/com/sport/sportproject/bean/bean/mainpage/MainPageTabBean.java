package com.sport.sportproject.bean.bean.mainpage;

import java.util.List;

/*
 *   梨花带雨,我见优伶  
 *      2019/4/18        
 */
public class MainPageTabBean {

    /**
     * data : {"big_image_slide":0,"default_index":1,"list":[{"api":"https://bkbapi.dqdgame.com/app/tabs/android/104.json?mark=gif&version=150","id":104,"label":"热门","recommend":false,"type":"hot","index_match_url":"https://sport-data.dqdgame.com/sd/biz/live/index?platform=android&version=150"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/1.json?mark=gif&version=150","id":1,"index_match_url":"https://sport-data.dqdgame.com/sd/biz/live/index?platform=android&version=150","label":"头条","recommend":true,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/121.json?mark=gif&version=150","id":121,"label":"NBA","recommend":false,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/123.json?mark=gif&version=150","id":123,"label":"中国篮球","recommend":false,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/11.json?mark=gif&version=150","id":11,"label":"集锦","recommend":false,"type":"video"},{"api":"https://bkbapi.dqdgame.com/app/tabs/wall.json?version=150","id":106,"label":"INS","recommend":false,"type":"wall"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/55.json?mark=gif&version=150","id":55,"label":"深度","recommend":false,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/37.json?mark=gif&version=150","id":37,"label":"闲情","recommend":false,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/125.json?mark=gif&version=150","id":125,"label":"世界杯","recommend":false,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/classifications.json?version=150","id":99,"label":"专题","recommend":false,"type":"classification"}]}
     * errCode : 0
     * message :
     */

    private DataBean data;
    private int errCode;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * big_image_slide : 0
         * default_index : 1
         * list : [{"api":"https://bkbapi.dqdgame.com/app/tabs/android/104.json?mark=gif&version=150","id":104,"label":"热门","recommend":false,"type":"hot"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/1.json?mark=gif&version=150","id":1,"index_match_url":"https://sport-data.dqdgame.com/sd/biz/live/index?platform=android&version=150","label":"头条","recommend":true,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/121.json?mark=gif&version=150","id":121,"label":"NBA","recommend":false,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/123.json?mark=gif&version=150","id":123,"label":"中国篮球","recommend":false,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/11.json?mark=gif&version=150","id":11,"label":"集锦","recommend":false,"type":"video"},{"api":"https://bkbapi.dqdgame.com/app/tabs/wall.json?version=150","id":106,"label":"INS","recommend":false,"type":"wall"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/55.json?mark=gif&version=150","id":55,"label":"深度","recommend":false,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/37.json?mark=gif&version=150","id":37,"label":"闲情","recommend":false,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/125.json?mark=gif&version=150","id":125,"label":"世界杯","recommend":false,"type":"normal"},{"api":"https://bkbapi.dqdgame.com/app/tabs/android/classifications.json?version=150","id":99,"label":"专题","recommend":false,"type":"classification"}]
         */

        private int big_image_slide;
        private int default_index;
        private List<ListBean> list;

        public int getBig_image_slide() {
            return big_image_slide;
        }

        public void setBig_image_slide(int big_image_slide) {
            this.big_image_slide = big_image_slide;
        }

        public int getDefault_index() {
            return default_index;
        }

        public void setDefault_index(int default_index) {
            this.default_index = default_index;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * api : https://bkbapi.dqdgame.com/app/tabs/android/104.json?mark=gif&version=150
             * id : 104
             * label : 热门
             * recommend : false
             * type : hot
             * index_match_url : https://sport-data.dqdgame.com/sd/biz/live/index?platform=android&version=150
             */

            private String api;
            private int id;
            private String label;
            private boolean recommend;
            private String type;
            private String index_match_url;

            public String getApi() {
                return api;
            }

            public void setApi(String api) {
                this.api = api;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public boolean isRecommend() {
                return recommend;
            }

            public void setRecommend(boolean recommend) {
                this.recommend = recommend;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getIndex_match_url() {
                return index_match_url;
            }

            public void setIndex_match_url(String index_match_url) {
                this.index_match_url = index_match_url;
            }
        }
    }
}
