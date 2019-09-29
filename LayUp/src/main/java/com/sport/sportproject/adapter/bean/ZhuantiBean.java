package com.sport.sportproject.adapter.bean;

import java.util.List;

/*
 *   梨花带雨,我见优伶  
 *      2019/4/21        
 */
public class ZhuantiBean {

    /**
     * id : 99
     * label : 专题
     * prev : null
     * next : null
     * articles : [{"id":23,"title":"今日观察：哈登失常时，火箭的赢球秘诀在哪里？","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/82/640x400/-/-/rB8AGFy8IFmADG4tAACDI5tWy6o927.jpg","published_at":"2023-04-20 16:15:15","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/23"},{"id":18,"title":"每日篮球教你一招：45°角使用突破教学","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/7E/640x400/-/-/rB8AdVy7LHSATBH4AATG0a8HEUY128.png","published_at":"2019-04-21 16:00:58","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/18"},{"id":8,"title":"字母哥两双，雄鹿客场力擒活塞夺赛点，格里芬复出空砍27分","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/80/640x400/-/-/rB8AdVy7zzyAKXTtAAFor-BYmhQ770.jpg","published_at":"2019-04-21 14:43:58","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/8"},{"id":22,"title":"上篮战术板：约基奇中心爆破！掘金外线多点开花","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/81/640x400/-/-/rB8AGFy8COGADh9JAAS0O4W_I6c537.png","published_at":"2021-04-20 14:10:19","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/22"},{"id":27,"title":"NBA今日看点：火箭赴盐湖城剑指赛点，马刺盼黑7誓再捍主场","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/7C/640x400/-/-/rB8AdVy6qmqAVGyzAALz0zA1HVQ978.jpg","published_at":"2019-04-21 07:00:15","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/27"},{"id":16,"title":"历史上的今天：幼鲨砍下53+18疯狂肆虐森林狼内线","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/7E/640x400/-/-/rB8AGFy7SdmAHm0FAAD_UXKuC6I467.jpg","published_at":"2019-04-21 00:33:58","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/16"},{"id":15,"title":"上篮问答：如何评价威少避答不喜欢记者的提问？","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/7E/640x400/-/-/rB8AdVy7MfaADKQnAANYnP9EUfI082.png","published_at":"2019-04-20 22:51:15","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/15"},{"id":38,"title":"为什么年轻的退役球员为老前辈们谋福利？这的确是他们应得的","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/7E/640x400/-/-/rB8AGFy7MdKAXZqOAATpowehFaQ445.png","published_at":"2019-04-20 22:51:02","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/38"},{"id":17,"title":"睡前一读：辽宁男篮这坎坷的一赛季\u2014\u2014挥别故人，再战明天","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/7A/640x400/-/-/rB8AdVy5_0eATo4kAACiTCGEsmg758.jpg","published_at":"2019-04-20 21:45:55","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/17"},{"id":40,"title":"费根专栏：爵士第三场可能会变阵，英格尔斯或成防哈登X因素","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/7D/640x400/-/-/rB8AGFy6yQ6AVmh5AA6Q9Q-gxQo884.png","published_at":"2019-04-20 20:08:24","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/40"},{"id":41,"title":"Inside the NBA：TNT天团齐夸KD，巴克利力挺开拓者夺冠","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/79/640x400/-/-/rB8AdVy5nYmAbaBzAAM9ybw8fNk869.jpg","published_at":"2019-04-20 03:35:54","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/41"},{"id":39,"title":"上篮小测试：NBA发生过的打架名场面，你都了解吗？","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/78/640x400/-/-/rB8AdVy5dm2ALL1oAAcS-314Ki0270.jpg","published_at":"2019-04-19 21:19:11","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/39"},{"id":19,"title":"左手地狱右手天堂，这是最烂的西蒙斯也是最好的西蒙斯","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/78/640x400/-/-/rB8AdVy5Zi-ACTocAAdKFbxbnWI695.png","published_at":"2019-04-19 19:15:42","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/19"},{"id":34,"title":"奥尼尔五大囧：笑中带泪，韦德想跳上技术台却被绊倒","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/79/640x400/-/-/rB8AdVy5mdGAar42AAKVgYMZ_P8052.png","published_at":"2019-04-19 17:57:48","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/34"},{"id":25,"title":"NBA今日五佳球：西蒙斯内线翻江倒海，怀特神兵天降击溃掘金","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/79/640x400/-/-/rB8AGFy5fXGALJEEAAIupNuUxM0731.png","published_at":"2019-04-19 15:50:45","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/25"},{"id":9,"title":"NBA今日最佳球员：西蒙斯13中11，取个人季后赛生涯新高31分","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/78/640x400/-/-/rB8AdVy5bHSAbkAxAAFzuztZRV0459.png","published_at":"2019-04-19 14:45:13","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/9"},{"id":11,"title":"37分大胜！新疆淘汰辽宁总决赛将战广东，郭艾伦仅得11分","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/74/640x400/-/-/rB8AdVy4c3SAHkJTAAFn0yI-p3Q772.jpg","published_at":"2019-04-19 07:00:49","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/11"},{"id":10,"title":"球色怡人：库里的迷妹\u2014\u2014\u201c天王嫂\u201d昆凌","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/74/640x400/-/-/rB8AGFy4QZmAdqd-AANFMPwr0Hw331.png","published_at":"2019-04-19 02:55:54","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/10"},{"id":24,"title":"东部各支球队在季后赛中的X因素，谁将成为系列赛的搅局者","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/73/640x400/-/-/rB8AdVy4H4WALdHsAADSnqP09rc326.jpg","published_at":"2019-04-18 19:14:11","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/24"},{"id":12,"title":"见证了卡特\u201c死亡之扣\u201d的经典战靴\u2014\u2014Nike Shox BB4","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/6F/640x400/-/-/rB8AdVy26pKAOw7cABAMguyHPX4713.png","published_at":"2019-04-17 19:13:25","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/12"},{"id":28,"title":"西子湖畔两日激战，中国三人篮球擂台赛华东分区赛圆满落幕","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/6E/640x400/-/-/rB8AdVy2mnuABPx7AASg8gEalHc761.jpg","published_at":"2019-04-17 11:17:24","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/28"},{"id":30,"title":"走近NBA：板凳席上的巨星，最佳第六人了解一下","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/01/640x400/-/-/rB8AdVyTZq6AZ4KYAAWl4OBAmBs646.png","published_at":"2019-04-16 07:00:19","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/30"},{"id":26,"title":"那一记该死的封闭针，毁了麦迪的整个职业生涯","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/03/23/640x400/-/-/ChM9m1wjjzyAdUPFAACj5KMCnz8315.jpg","published_at":"2019-04-11 13:12:29","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/26"},{"id":14,"title":"李春江晒领带：依然是生死之战","description":"今晚19点35分，广厦将在主场迎战新疆，目前广厦大比分1-2落后。","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/23/640x400/-/-/rB8AdVyjGimAZCcBAAU1SeYb1Rg627.png","published_at":"2019-04-02 16:15:59","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/14"},{"id":33,"title":"奇葩说：毒奶界23vs24\u2014\u2014科比毒奶灭全体，老詹毒奶坑自己","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/05/25/640x400/-/-/ChOlBlyYhdOAUspCAAGzWFiZmuI967.jpg","published_at":"2019-03-25 20:34:15","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/33"},{"id":31,"title":"NBA水浒108将第1位\u2014\u2014\u201c及时雨\u201d姚明","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/05/02/640x400/-/-/ChM9m1yMwamAMqYJAAEbj5KwO8k344.jpg","published_at":"2019-03-16 17:28:12","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/31"},{"id":37,"title":"美媒评NBA历史主教练排名：第一位\u2014\u2014菲尔-杰克逊","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/04/F2/640x400/-/-/ChOlBlyJB_GAS9tOAADE5SlDZ1Y480.jpg","published_at":"2019-03-13 21:36:25","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/37"},{"id":13,"title":"不说篮球：游泳世界冠军宁泽涛在26岁生日当天宣布退役","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/04/D1/640x400/-/-/ChM9m1x_emyAWu5ZAAUWV5QRv74524.png","published_at":"2019-03-06 15:45:21","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/13"},{"id":36,"title":"2013总决赛回忆录：时代转折点上的视觉盛宴","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/04/23/640x400/-/-/ChOlBlxeeBGAfGiBAAr0mjAR95c022.png","published_at":"2019-03-01 09:30:08","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/36"},{"id":35,"title":"上篮单挑之王：乔丹力压科比夺魁，麦迪AI分列三四名","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/04/48/640x400/-/-/ChM9m1xnuomATORGAA0lPV9JTtQ587.png","published_at":"2019-02-18 08:25:13","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/35"},{"id":32,"title":"NBA历年MVP和最佳阵容回顾之2018：勇士4年3冠，哈登MVP","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/04/49/640x400/-/-/ChM9m1xn5TmAdWkEAADrAkY0X54324.jpg","published_at":"2019-02-16 22:01:12","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/32"},{"id":29,"title":"【2K评队史最佳阵容】洛杉矶湖人：魔韦科勾鲨领衔","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/03/B1/640x400/-/-/ChM9m1xBiNCAP8HbAAgiZbh9FVw057.png","published_at":"2019-01-18 22:04:58","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/29"},{"id":21,"title":"ESPN百大球星第1位：迈克尔-不好意思就是我-乔丹","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/03/9E/640x400/-/-/ChOlBlw9fgiAK7OPAAYGABnm0n0546.png","published_at":"2019-01-16 03:35:36","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/21"},{"id":20,"title":"美媒重排选秀之2014年：约基奇超级逆袭，维金斯力压恩比德","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/02/D7/640x400/-/-/ChM9m1wV69KAA2ZaAAC08LZvwOc976.jpg","published_at":"2018-12-16 17:18:01","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/20"},{"id":6,"title":"外国也有\u201c大喷子\u201d：德罗赞抗詹终成功，本场MVP是隆多？","description":"","thumb":"https://img1.dqdgame.com/fastdfs/M00/00/54/640x400/-/-/ChM9m1vVgfKAFESgAAFgcU5wTfo178.jpg","published_at":"2018-10-28 19:00:25","channel":"ccover","api":"http://bkbapi.dqdgame.com/old/columns/6"}]
     */

    private int id;
    private String label;
    private Object prev;
    private Object next;
    private List<ArticlesBean> articles;

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

    public Object getPrev() {
        return prev;
    }

    public void setPrev(Object prev) {
        this.prev = prev;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public List<ArticlesBean> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesBean> articles) {
        this.articles = articles;
    }

    public static class ArticlesBean {
        /**
         * id : 23
         * title : 今日观察：哈登失常时，火箭的赢球秘诀在哪里？
         * description :
         * thumb : https://img1.dqdgame.com/fastdfs/M00/00/82/640x400/-/-/rB8AGFy8IFmADG4tAACDI5tWy6o927.jpg
         * published_at : 2023-04-20 16:15:15
         * channel : ccover
         * api : http://bkbapi.dqdgame.com/old/columns/23
         */

        private int id;
        private String title;
        private String description;
        private String thumb;
        private String published_at;
        private String channel;
        private String api;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getPublished_at() {
            return published_at;
        }

        public void setPublished_at(String published_at) {
            this.published_at = published_at;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getApi() {
            return api;
        }

        public void setApi(String api) {
            this.api = api;
        }
    }
}
