package com.sport.sportproject.ui.fragment_match.bean;

import java.util.List;

/**
 * Created by 华为 on 2019/7/9.
 */

public class MatchName {
    /**
     * errno : 0
     * errmsg :
     * data : [{"match_id":11528,"sts_A":{"name":"迈耶斯-莱昂纳德","logo":"http://img1.dqdgame.com/fastdfs/M00/00/47/ChM9m1vROYiARBMjAAAZ4-dp_xs645.jpg","tips":"30分-12篮板-3助攻"},"sts_B":{"name":"斯蒂芬-库里","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChOlBlvRM4SAPAWvAAAbqfS6MQw679.jpg","tips":"37分-13篮板-11助攻"},"transfer":"1","news":null},{"match_id":11532,"sts_A":{"name":"凯尔-洛瑞","logo":"http://img1.dqdgame.com/fastdfs/M00/00/47/ChM9m1vROYuARIHNAAAavqEMd7g987.jpg","tips":"25分-5篮板-6助攻"},"sts_B":{"name":"克里斯-米德尔顿","logo":"http://img1.dqdgame.com/fastdfs/M00/00/47/ChOlBlvRO-KAYaR-AAAa6MXt7u0924.jpg","tips":"30分-6篮板-7助攻"},"transfer":"1","news":null},{"match_id":11579,"sts_A":{"name":"扬尼斯-阿德托昆博","logo":"http://img1.dqdgame.com/fastdfs/M00/00/47/ChOlBlvRO_KAJjqOAAAb57TtX9Q265.jpg","tips":"24分-6篮板-6助攻"},"sts_B":{"name":"卡哇伊-莱昂纳德","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChM9m1vRMyKALG8CAAAcYbrHb5Q347.jpg","tips":"35分-7篮板-9助攻"},"transfer":"1","news":null},{"match_id":11596,"sts_A":{"name":"卡哇伊-莱昂纳德","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChM9m1vRMyKALG8CAAAcYbrHb5Q347.jpg","tips":"27分-17篮板-7助攻"},"sts_B":{"name":"扬尼斯-阿德托昆博","logo":"http://img1.dqdgame.com/fastdfs/M00/00/47/ChOlBlvRO_KAJjqOAAAb57TtX9Q265.jpg","tips":"21分-11篮板-4助攻"},"transfer":"1","news":null},{"match_id":11607,"sts_A":{"name":"帕斯卡尔-西亚卡姆","logo":"http://img1.dqdgame.com/fastdfs/M00/00/47/ChM9m1vROYuACb89AAAdekyXODE549.jpg","tips":"32分-8篮板-5助攻"},"sts_B":{"name":"斯蒂芬-库里","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChOlBlvRM4SAPAWvAAAbqfS6MQw679.jpg","tips":"34分-5篮板-5助攻"},"transfer":"1","news":null},{"match_id":11608,"sts_A":{"name":"卡哇伊-莱昂纳德","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChM9m1vRMyKALG8CAAAcYbrHb5Q347.jpg","tips":"34分-14篮板-3助攻"},"sts_B":{"name":"克莱-汤普森","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChOlBlvROWSAAKViAAAc-9Omttc347.jpg","tips":"25分-5篮板-5助攻"},"transfer":"1","news":null},{"match_id":11609,"sts_A":{"name":"斯蒂芬-库里","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChOlBlvRM4SAPAWvAAAbqfS6MQw679.jpg","tips":"47分-8篮板-7助攻"},"sts_B":{"name":"卡哇伊-莱昂纳德","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChM9m1vRMyKALG8CAAAcYbrHb5Q347.jpg","tips":"30分-7篮板-6助攻"},"transfer":"1","news":null},{"match_id":11610,"sts_A":{"name":"克莱-汤普森","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChOlBlvROWSAAKViAAAc-9Omttc347.jpg","tips":"28分-3篮板-2助攻"},"sts_B":{"name":"卡哇伊-莱昂纳德","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChM9m1vRMyKALG8CAAAcYbrHb5Q347.jpg","tips":"36分-12篮板-2助攻"},"transfer":"1","news":null},{"match_id":11619,"sts_A":{"name":"卡哇伊-莱昂纳德","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChM9m1vRMyKALG8CAAAcYbrHb5Q347.jpg","tips":"26分-12篮板-6助攻"},"sts_B":{"name":"斯蒂芬-库里","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChOlBlvRM4SAPAWvAAAbqfS6MQw679.jpg","tips":"31分-8篮板-7助攻"},"transfer":"1","news":null},{"match_id":11620,"sts_A":{"name":"克莱-汤普森","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChOlBlvROWSAAKViAAAc-9Omttc347.jpg","tips":"30分-5篮板"},"sts_B":{"name":"凯尔-洛瑞","logo":"http://img1.dqdgame.com/fastdfs/M00/00/47/ChM9m1vROYuARIHNAAAavqEMd7g987.jpg","tips":"26分-7篮板-10助攻"},"transfer":"1","news":null}]
     */
    private int errno;
    private String errmsg;
    private List<DataBean> data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * match_id : 11528
         * sts_A : {"name":"迈耶斯-莱昂纳德","logo":"http://img1.dqdgame.com/fastdfs/M00/00/47/ChM9m1vROYiARBMjAAAZ4-dp_xs645.jpg","tips":"30分-12篮板-3助攻"}
         * sts_B : {"name":"斯蒂芬-库里","logo":"http://img1.dqdgame.com/fastdfs/M00/00/46/ChOlBlvRM4SAPAWvAAAbqfS6MQw679.jpg","tips":"37分-13篮板-11助攻"}
         * transfer : 1
         * news : null
         */

        private int match_id;
        private StsABean sts_A;
        private StsBBean sts_B;
        private String transfer;
        private Object news;

        public int getMatch_id() {
            return match_id;
        }

        public void setMatch_id(int match_id) {
            this.match_id = match_id;
        }

        public StsABean getSts_A() {
            return sts_A;
        }

        public void setSts_A(StsABean sts_A) {
            this.sts_A = sts_A;
        }

        public StsBBean getSts_B() {
            return sts_B;
        }

        public void setSts_B(StsBBean sts_B) {
            this.sts_B = sts_B;
        }

        public String getTransfer() {
            return transfer;
        }

        public void setTransfer(String transfer) {
            this.transfer = transfer;
        }

        public Object getNews() {
            return news;
        }

        public void setNews(Object news) {
            this.news = news;
        }

        public static class StsABean {
            /**
             * name : 迈耶斯-莱昂纳德
             * logo : http://img1.dqdgame.com/fastdfs/M00/00/47/ChM9m1vROYiARBMjAAAZ4-dp_xs645.jpg
             * tips : 30分-12篮板-3助攻
             */

            private String name;
            private String logo;
            private String tips;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }
        }

        public static class StsBBean {
            /**
             * name : 斯蒂芬-库里
             * logo : http://img1.dqdgame.com/fastdfs/M00/00/46/ChOlBlvRM4SAPAWvAAAbqfS6MQw679.jpg
             * tips : 37分-13篮板-11助攻
             */

            private String name;
            private String logo;
            private String tips;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }

            @Override
            public String toString() {
                return "StsBBean{" +
                        "name='" + name + '\'' +
                        ", logo='" + logo + '\'' +
                        ", tips='" + tips + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "match_id=" + match_id +
                    ", sts_A=" + sts_A +
                    ", sts_B=" + sts_B +
                    ", transfer='" + transfer + '\'' +
                    ", news=" + news +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MatchName{" +
                "errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }
}
