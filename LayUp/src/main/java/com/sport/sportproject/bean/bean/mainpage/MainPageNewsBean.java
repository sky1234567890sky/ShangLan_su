package com.sport.sportproject.bean.bean.mainpage;

import java.util.List;

/*
 *   梨花带雨,我见优伶  
 *      2019/4/18
   *    头条
 */
public class MainPageNewsBean {

    private String fresh;
    private String hotwords;
    private int id;
    private String label;
    private String max;
    private String min;
    private String next;
    private int page;
    private String prev;
    private List<ArticlesBean> articles;
    private List<RecommendBean> recommend;

    public String getFresh() {
        return fresh;
    }

    public void setFresh(String fresh) {
        this.fresh = fresh;
    }

    public String getHotwords() {
        return hotwords;
    }

    public void setHotwords(String hotwords) {
        this.hotwords = hotwords;
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

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public List<ArticlesBean> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesBean> articles) {
        this.articles = articles;
    }

    public List<RecommendBean> getRecommend() {
        return recommend;
    }

    public void setRecommend(List<RecommendBean> recommend) {
        this.recommend = recommend;
    }

    public static class ArticlesBean {
        @Override
        public String toString() {
            return "ArticlesBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", share_title='" + share_title + '\'' +
                    ", b_description='" + b_description + '\'' +
                    ", comments_total=" + comments_total +
                    ", share='" + share + '\'' +
                    ", thumb='" + thumb + '\'' +
                    ", top=" + top +
                    ", top_color='" + top_color + '\'' +
                    ", url='" + url + '\'' +
                    ", url1='" + url1 + '\'' +
                    ", scheme='" + scheme + '\'' +
                    ", is_video=" + is_video +
                    ", new_video_detail=" + new_video_detail +
                    ", collection_type=" + collection_type +
                    ", add_to_tab=" + add_to_tab +
                    ", is_redirect_h5=" + is_redirect_h5 +
                    ", ignore='" + ignore + '\'' +
                    ", video_info=" + video_info +
                    ", cover=" + cover +
                    ", template='" + template + '\'' +
                    ", show_comments=" + show_comments +
                    ", published_at='" + published_at + '\'' +
                    ", sort_timestamp=" + sort_timestamp +
                    ", channel='" + channel + '\'' +
                    ", description='" + description + '\'' +
                    ", label='" + label + '\'' +
                    ", label_color='" + label_color + '\'' +
                    ", album=" + album +
                    ", extend=" + extend +
                    '}';
        }

        /**
         * add_to_tab : 0
         * b_description :
         * channel : article
         * comments_total : 102
         * description :
         * id : 43902
         * ignore :
         * is_redirect_h5 : false
         * is_video : false
         * published_at : 2024-04-16 11:56:09
         * scheme : shanglan://news/43902
         * share : https://bkbapi.dqdgame.com/article/43902
         * share_title : 哈登32分三双迎里程碑，火箭胜爵士大比分2-0，保罗17分
         * show_comments : true
         * sort_timestamp : 1713239769
         * template : news.html
         * thumb : https://img1.dqdgame.com/fastdfs/M00/00/72/180x135/crop/-/rB8AdVy37WeAVvhNAAI13QLNkQ8317.jpg
         * title : 哈登32分三双迎里程碑，火箭胜爵士大比分2-0，保罗17分
         * top : true
         * top_color : #4782c4
         * url : https://bkbapi.dqdgame.com/article/43902.html?from=tab_1
         * url1 : https://bkbapi.dqdgame.com/article/43902.html?from=tab_1
         * label : 深度
         * label_color : #4782c4
         * cover : {"pic":"https://img1.dqdgame.com/fastdfs/M00/00/70/640x400/-/-/rB8AdVy3b22AGjdpAAIaLw8jqD0977.jpg"}
         * new_video_detail : 1
         * video_info : {"size":2,"vertical_screen":0,"video_hash":"2190aca7debb6d0340a609511a027f19","video_height":368,"video_mode":"player","video_src":"https://o6yh618n9.qnssl.com/2IoqLdbq_8535255551.mp4","video_time":"00:18","video_width":640,"visit_total":775}
         */
        private int id;
        private String title;
        private String share_title;
        private String b_description;
        private int comments_total;
        private String share;
        private String thumb;
        private boolean top;
        private String top_color;
        private String url;
        private String url1;
        private String scheme;
        private boolean is_video;
        private int new_video_detail;
        private Object collection_type;
        private Object add_to_tab;
        private boolean is_redirect_h5;
        private String ignore;
        private VideoInfoBean video_info;
        private CoverBean cover;
        private String template;
        private boolean show_comments;
        private String published_at;
        private String sort_timestamp;
        private String channel;
        private String description;
        private String label;
        private String label_color;
        private AlbumBean album;
        private List<String> extend;

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

        public String getShare_title() {
            return share_title;
        }

        public void setShare_title(String share_title) {
            this.share_title = share_title;
        }

        public String getB_description() {
            return b_description;
        }

        public void setB_description(String b_description) {
            this.b_description = b_description;
        }

        public int getComments_total() {
            return comments_total;
        }

        public void setComments_total(int comments_total) {
            this.comments_total = comments_total;
        }

        public String getShare() {
            return share;
        }

        public void setShare(String share) {
            this.share = share;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public boolean isTop() {
            return top;
        }

        public void setTop(boolean top) {
            this.top = top;
        }

        public String getTop_color() {
            return top_color;
        }

        public void setTop_color(String top_color) {
            this.top_color = top_color;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl1() {
            return url1;
        }

        public void setUrl1(String url1) {
            this.url1 = url1;
        }

        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public boolean isIs_video() {
            return is_video;
        }

        public void setIs_video(boolean is_video) {
            this.is_video = is_video;
        }

        public int getNew_video_detail() {
            return new_video_detail;
        }

        public void setNew_video_detail(int new_video_detail) {
            this.new_video_detail = new_video_detail;
        }

        public Object getCollection_type() {
            return collection_type;
        }

        public void setCollection_type(Object collection_type) {
            this.collection_type = collection_type;
        }

        public Object getAdd_to_tab() {
            return add_to_tab;
        }

        public void setAdd_to_tab(Object add_to_tab) {
            this.add_to_tab = add_to_tab;
        }

        public boolean isIs_redirect_h5() {
            return is_redirect_h5;
        }

        public void setIs_redirect_h5(boolean is_redirect_h5) {
            this.is_redirect_h5 = is_redirect_h5;
        }

        public String getIgnore() {
            return ignore;
        }

        public void setIgnore(String ignore) {
            this.ignore = ignore;
        }

        public VideoInfoBean getVideo_info() {
            return video_info;
        }

        public void setVideo_info(VideoInfoBean video_info) {
            this.video_info = video_info;
        }

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public boolean isShow_comments() {
            return show_comments;
        }

        public void setShow_comments(boolean show_comments) {
            this.show_comments = show_comments;
        }

        public String getPublished_at() {
            return published_at;
        }

        public void setPublished_at(String published_at) {
            this.published_at = published_at;
        }

        public String getSort_timestamp() {
            return sort_timestamp;
        }

        public void setSort_timestamp(String sort_timestamp) {
            this.sort_timestamp = sort_timestamp;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getLabel_color() {
            return label_color;
        }

        public void setLabel_color(String label_color) {
            this.label_color = label_color;
        }

        public AlbumBean getAlbum() {
            return album;
        }

        public void setAlbum(AlbumBean album) {
            this.album = album;
        }

        public List<String> getExtend() {
            return extend;
        }

        public void setExtend(List<String> extend) {
            this.extend = extend;
        }

        public static class VideoInfoBean {
            /**
             * video_src : https://o6yh618n9.qnssl.com/ok5tVuTw_2110385551.mp4
             * video_hash : 79be6638ac2a62a415ecd093ec55ef70
             * video_time : 03:05
             * video_mode : player
             * video_width : 640
             * video_height : 368
             * visit_total : 1176
             * vertical_screen : 0
             * size : 14
             */

            private String video_src;
            private String video_hash;
            private String video_time;
            private String video_mode;
            private int video_width;
            private int video_height;
            private int visit_total;
            private int vertical_screen;
            private int size;

            public String getVideo_src() {
                return video_src;
            }

            public void setVideo_src(String video_src) {
                this.video_src = video_src;
            }

            public String getVideo_hash() {
                return video_hash;
            }

            public void setVideo_hash(String video_hash) {
                this.video_hash = video_hash;
            }

            public String getVideo_time() {
                return video_time;
            }

            public void setVideo_time(String video_time) {
                this.video_time = video_time;
            }

            public String getVideo_mode() {
                return video_mode;
            }

            public void setVideo_mode(String video_mode) {
                this.video_mode = video_mode;
            }

            public int getVideo_width() {
                return video_width;
            }

            public void setVideo_width(int video_width) {
                this.video_width = video_width;
            }

            public int getVideo_height() {
                return video_height;
            }

            public void setVideo_height(int video_height) {
                this.video_height = video_height;
            }

            public int getVisit_total() {
                return visit_total;
            }

            public void setVisit_total(int visit_total) {
                this.visit_total = visit_total;
            }

            public int getVertical_screen() {
                return vertical_screen;
            }

            public void setVertical_screen(int vertical_screen) {
                this.vertical_screen = vertical_screen;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            @Override
            public String toString() {
                return "VideoInfoBean{" +
                        "video_src='" + video_src + '\'' +
                        ", video_hash='" + video_hash + '\'' +
                        ", video_time='" + video_time + '\'' +
                        ", video_mode='" + video_mode + '\'' +
                        ", video_width=" + video_width +
                        ", video_height=" + video_height +
                        ", visit_total=" + visit_total +
                        ", vertical_screen=" + vertical_screen +
                        ", size=" + size +
                        '}';
            }
        }

        public static class CoverBean {
            /**
             * pic : https://img1.dqdgame.com/fastdfs/M00/00/81/640x400/-/-/rB8AdVy8FaOALe7UAAvDxR_OLqk532.png
             */

            private String pic;

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            @Override
            public String toString() {
                return "CoverBean{" +
                        "pic='" + pic + '\'' +
                        '}';
            }
        }

        public static class AlbumBean {
            /**
             * total : 23
             * pics : ["https://img1.dqdgame.com/fastdfs/M00/00/7A/180x135/crop/-/rB8AdVy51hGAPMPGAAJxzbUAD6Q117.jpg","https://img1.dqdgame.com/fastdfs/M00/00/7A/180x135/crop/-/rB8AGFy51hGAA3oUAAJpny1ms-Y903.jpg","https://img1.dqdgame.com/fastdfs/M00/00/7A/180x135/crop/-/rB8AGFy51hGADuFkAAJIO7Vxlcg518.jpg"]
             */

            private int total;
            private List<String> pics;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public List<String> getPics() {
                return pics;
            }

            public void setPics(List<String> pics) {
                this.pics = pics;
            }

            @Override
            public String toString() {
                return "AlbumBean{" +
                        "total=" + total +
                        ", pics=" + pics +
                        '}';
            }
        }
    }

    public static class RecommendBean {
        @Override
        public String toString() {
            return "RecommendBean{" +
                    "add_to_tab='" + add_to_tab + '\'' +
                    ", b_description='" + b_description + '\'' +
                    ", channel='" + channel + '\'' +
                    ", comments_total=" + comments_total +
                    ", description='" + description + '\'' +
                    ", id=" + id +
                    ", ignore='" + ignore + '\'' +
                    ", is_redirect_h5=" + is_redirect_h5 +
                    ", is_video=" + is_video +
                    ", published_at='" + published_at + '\'' +
                    ", scheme='" + scheme + '\'' +
                    ", share='" + share + '\'' +
                    ", share_title='" + share_title + '\'' +
                    ", show_comments=" + show_comments +
                    ", sort_timestamp=" + sort_timestamp +
                    ", template='" + template + '\'' +
                    ", thumb='" + thumb + '\'' +
                    ", title='" + title + '\'' +
                    ", top=" + top +
                    ", top_color='" + top_color + '\'' +
                    ", url='" + url + '\'' +
                    ", url1='" + url1 + '\'' +
                    ", cover=" + cover +
                    ", new_video_detail=" + new_video_detail +
                    ", video_info=" + video_info +
                    ", extend=" + extend +
                    '}';
        }

        /**
         * add_to_tab : 0
         * b_description :
         * channel : article
         * comments_total : 56
         * description :
         * id : 43862
         * ignore :
         * is_redirect_h5 : false
         * is_video : false
         * published_at : 2019-04-18 15:20:01
         * scheme : shanglan://news/43862
         * share : https://www.dqdgame.com/article/43862
         * share_title : 欧文37分，绿军末节16-0攻击波逆转步行者，大比分2-0领先
         * show_comments : true
         * sort_timestamp : 1555572001
         * template : news.html
         * thumb : https://img1.dqdgame.com/fastdfs/M00/00/71/640x400/-/-/rB8AGFy30HmAXpDMAAGuSJkDcNw459.jpg
         * title : 欧文37分，绿军末节16-0攻击波逆转步行者，大比分2-0领先
         * top : false
         * top_color :
         * url : https://bkbapi.dqdgame.com/article/43862.html
         * url1 : https://bkbapi.dqdgame.com/article/43862.html
         * cover : {"pic":"https://img1.dqdgame.com/fastdfs/M00/00/6F/640x400/-/-/rB8AdVy29FaAMz8tABVNbUMJOZ0497.png"}
         * extend : ["cover"]
         * new_video_detail : 1
         * video_info : {"size":17,"vertical_screen":0,"video_hash":"278170c0b32fed7e387e62e5e55328e7","video_height":368,"video_mode":"player","video_src":"https://o6yh618n9.qnssl.com/y9BcDpwk_3763945551.mp4","video_time":"03:38","video_width":640,"visit_total":6187}
         */

        private String add_to_tab;
        private String b_description;
        private String channel;
        private int comments_total;
        private String description;
        private int id;
        private String ignore;
        private boolean is_redirect_h5;
        private boolean is_video;
        private String published_at;
        private String scheme;
        private String share;
        private String share_title;
        private boolean show_comments;
        private int sort_timestamp;
        private String template;
        private String thumb;
        private String title;
        private boolean top;
        private String top_color;
        private String url;
        private String url1;
        private CoverBeanX cover;
        private int new_video_detail;
        private VideoInfoBeanX video_info;
        private List<String> extend;

        public String getAdd_to_tab() {
            return add_to_tab;
        }

        public void setAdd_to_tab(String add_to_tab) {
            this.add_to_tab = add_to_tab;
        }

        public String getB_description() {
            return b_description;
        }

        public void setB_description(String b_description) {
            this.b_description = b_description;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public int getComments_total() {
            return comments_total;
        }

        public void setComments_total(int comments_total) {
            this.comments_total = comments_total;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIgnore() {
            return ignore;
        }

        public void setIgnore(String ignore) {
            this.ignore = ignore;
        }

        public boolean isIs_redirect_h5() {
            return is_redirect_h5;
        }

        public void setIs_redirect_h5(boolean is_redirect_h5) {
            this.is_redirect_h5 = is_redirect_h5;
        }

        public boolean isIs_video() {
            return is_video;
        }

        public void setIs_video(boolean is_video) {
            this.is_video = is_video;
        }

        public String getPublished_at() {
            return published_at;
        }

        public void setPublished_at(String published_at) {
            this.published_at = published_at;
        }

        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public String getShare() {
            return share;
        }

        public void setShare(String share) {
            this.share = share;
        }

        public String getShare_title() {
            return share_title;
        }

        public void setShare_title(String share_title) {
            this.share_title = share_title;
        }

        public boolean isShow_comments() {
            return show_comments;
        }

        public void setShow_comments(boolean show_comments) {
            this.show_comments = show_comments;
        }

        public int getSort_timestamp() {
            return sort_timestamp;
        }

        public void setSort_timestamp(int sort_timestamp) {
            this.sort_timestamp = sort_timestamp;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isTop() {
            return top;
        }

        public void setTop(boolean top) {
            this.top = top;
        }

        public String getTop_color() {
            return top_color;
        }

        public void setTop_color(String top_color) {
            this.top_color = top_color;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl1() {
            return url1;
        }

        public void setUrl1(String url1) {
            this.url1 = url1;
        }

        public CoverBeanX getCover() {
            return cover;
        }

        public void setCover(CoverBeanX cover) {
            this.cover = cover;
        }

        public int getNew_video_detail() {
            return new_video_detail;
        }

        public void setNew_video_detail(int new_video_detail) {
            this.new_video_detail = new_video_detail;
        }

        public VideoInfoBeanX getVideo_info() {
            return video_info;
        }

        public void setVideo_info(VideoInfoBeanX video_info) {
            this.video_info = video_info;
        }

        public List<String> getExtend() {
            return extend;
        }

        public void setExtend(List<String> extend) {
            this.extend = extend;
        }

        public static class CoverBeanX {
            /**
             * pic : https://img1.dqdgame.com/fastdfs/M00/00/6F/640x400/-/-/rB8AdVy29FaAMz8tABVNbUMJOZ0497.png
             */

            private String pic;

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }
        }

        public static class VideoInfoBeanX {
            /**
             * size : 17
             * vertical_screen : 0
             * video_hash : 278170c0b32fed7e387e62e5e55328e7
             * video_height : 368
             * video_mode : player
             * video_src : https://o6yh618n9.qnssl.com/y9BcDpwk_3763945551.mp4
             * video_time : 03:38
             * video_width : 640
             * visit_total : 6187
             */

            private int size;
            private int vertical_screen;
            private String video_hash;
            private int video_height;
            private String video_mode;
            private String video_src;
            private String video_time;
            private int video_width;
            private int visit_total;

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getVertical_screen() {
                return vertical_screen;
            }

            public void setVertical_screen(int vertical_screen) {
                this.vertical_screen = vertical_screen;
            }

            public String getVideo_hash() {
                return video_hash;
            }

            public void setVideo_hash(String video_hash) {
                this.video_hash = video_hash;
            }

            public int getVideo_height() {
                return video_height;
            }

            public void setVideo_height(int video_height) {
                this.video_height = video_height;
            }

            public String getVideo_mode() {
                return video_mode;
            }

            public void setVideo_mode(String video_mode) {
                this.video_mode = video_mode;
            }

            public String getVideo_src() {
                return video_src;
            }

            public void setVideo_src(String video_src) {
                this.video_src = video_src;
            }

            public String getVideo_time() {
                return video_time;
            }

            public void setVideo_time(String video_time) {
                this.video_time = video_time;
            }

            public int getVideo_width() {
                return video_width;
            }

            public void setVideo_width(int video_width) {
                this.video_width = video_width;
            }

            public int getVisit_total() {
                return visit_total;
            }

            public void setVisit_total(int visit_total) {
                this.visit_total = visit_total;
            }
        }

    }

    @Override
    public String toString() {
        return "MainPageNewsBean{" +
                "fresh='" + fresh + '\'' +
                ", hotwords='" + hotwords + '\'' +
                ", id=" + id +
                ", label='" + label + '\'' +
                ", max='" + max + '\'' +
                ", min='" + min + '\'' +
                ", next='" + next + '\'' +
                ", page=" + page +
                ", prev='" + prev + '\'' +
                ", articles=" + articles +
                ", recommend=" + recommend +
                '}';
    }
}
