package com.sport.sportproject.bean.bean.data;

import java.util.List;

/*
 *   梨花带雨,我见优伶  
 *      2019/5/4        
 */
public class DataStandingBean {


    private String template;
    private ContentBeanX content;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public ContentBeanX getContent() {
        return content;
    }

    public void setContent(ContentBeanX content) {
        this.content = content;
    }

    public static class ContentBeanX {


        private String description;
        private List<RoundsBean> rounds;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<RoundsBean> getRounds() {
            return rounds;
        }

        public void setRounds(List<RoundsBean> rounds) {
            this.rounds = rounds;
        }

        public static class RoundsBean {

            private ContentBean content;
            private String template;

            public ContentBean getContent() {
                return content;
            }

            public void setContent(ContentBean content) {
                this.content = content;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public static class ContentBean {

                private String name;
                private List<DataBean> data;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<DataBean> getData() {
                    return data;
                }

                public void setData(List<DataBean> data) {
                    this.data = data;
                }

                public static class DataBean {

                    private int fs_A;
                    private int fs_B;
                    private boolean show;
                    private int team_A_id;
                    private String team_A_logo;
                    private String team_A_name;
                    private int team_A_rank;
                    private int team_B_id;
                    private String team_B_logo;
                    private String team_B_name;
                    private int team_B_rank;
                    private String winner;


                    private int end;
                    private String name;
                    private String top;
                    private List<DataBeane> data;
                    private List<String> header;

                    public int getFs_A() {
                        return fs_A;
                    }

                    public void setFs_A(int fs_A) {
                        this.fs_A = fs_A;
                    }

                    public int getFs_B() {
                        return fs_B;
                    }

                    public void setFs_B(int fs_B) {
                        this.fs_B = fs_B;
                    }

                    public boolean isShow() {
                        return show;
                    }

                    public void setShow(boolean show) {
                        this.show = show;
                    }

                    public int getTeam_A_id() {
                        return team_A_id;
                    }

                    public void setTeam_A_id(int team_A_id) {
                        this.team_A_id = team_A_id;
                    }

                    public String getTeam_A_logo() {
                        return team_A_logo;
                    }

                    public void setTeam_A_logo(String team_A_logo) {
                        this.team_A_logo = team_A_logo;
                    }

                    public String getTeam_A_name() {
                        return team_A_name;
                    }

                    public void setTeam_A_name(String team_A_name) {
                        this.team_A_name = team_A_name;
                    }

                    public int getTeam_A_rank() {
                        return team_A_rank;
                    }

                    public void setTeam_A_rank(int team_A_rank) {
                        this.team_A_rank = team_A_rank;
                    }

                    public int getTeam_B_id() {
                        return team_B_id;
                    }

                    public void setTeam_B_id(int team_B_id) {
                        this.team_B_id = team_B_id;
                    }

                    public String getTeam_B_logo() {
                        return team_B_logo;
                    }

                    public void setTeam_B_logo(String team_B_logo) {
                        this.team_B_logo = team_B_logo;
                    }

                    public String getTeam_B_name() {
                        return team_B_name;
                    }

                    public void setTeam_B_name(String team_B_name) {
                        this.team_B_name = team_B_name;
                    }

                    public int getTeam_B_rank() {
                        return team_B_rank;
                    }

                    public void setTeam_B_rank(int team_B_rank) {
                        this.team_B_rank = team_B_rank;
                    }

                    public String getWinner() {
                        return winner;
                    }

                    public void setWinner(String winner) {
                        this.winner = winner;
                    }

                    public int getEnd() {
                        return end;
                    }

                    public void setEnd(int end) {
                        this.end = end;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getTop() {
                        return top;
                    }

                    public void setTop(String top) {
                        this.top = top;
                    }

                    public List<DataBeane> getDatae() {
                        return data;
                    }

                    public void setData(List<DataBeane> datae) {
                        this.data = datae;
                    }

                    public List<String> getHeader() {
                        return header;
                    }

                    public void setHeader(List<String> header) {
                        this.header = header;
                    }


                    public static class DataBeane {
                        /**
                         * gb : -
                         * matches_total : 82
                         * rank : 1
                         * streak : 1连败
                         * team_id : 17
                         * team_logo : http://img1.dqdgame.com/fastdfs/M00/00/24/ChOlBlvGrr6AcmobAAAe3sUXDds953.png
                         * team_name : 勇士
                         * win_lost : 57-25
                         * win_rate : 69.5%
                         */

                        private String gb;
                        private String matches_total;
                        private String rank;
                        private String streak;
                        private String team_id;
                        private String team_logo;
                        private String team_name;
                        private String win_lost;
                        private String win_rate;

                        public String getGb() {
                            return gb;
                        }

                        public void setGb(String gb) {
                            this.gb = gb;
                        }

                        public String getMatches_total() {
                            return matches_total;
                        }

                        public void setMatches_total(String matches_total) {
                            this.matches_total = matches_total;
                        }

                        public String getRank() {
                            return rank;
                        }

                        public void setRank(String rank) {
                            this.rank = rank;
                        }

                        public String getStreak() {
                            return streak;
                        }

                        public void setStreak(String streak) {
                            this.streak = streak;
                        }

                        public String getTeam_id() {
                            return team_id;
                        }

                        public void setTeam_id(String team_id) {
                            this.team_id = team_id;
                        }

                        public String getTeam_logo() {
                            return team_logo;
                        }

                        public void setTeam_logo(String team_logo) {
                            this.team_logo = team_logo;
                        }

                        public String getTeam_name() {
                            return team_name;
                        }

                        public void setTeam_name(String team_name) {
                            this.team_name = team_name;
                        }

                        public String getWin_lost() {
                            return win_lost;
                        }

                        public void setWin_lost(String win_lost) {
                            this.win_lost = win_lost;
                        }

                        public String getWin_rate() {
                            return win_rate;
                        }

                        public void setWin_rate(String win_rate) {
                            this.win_rate = win_rate;
                        }

                        @Override
                        public String toString() {
                            return "DataBeane{" +
                                    "gb='" + gb + '\'' +
                                    ", matches_total='" + matches_total + '\'' +
                                    ", rank='" + rank + '\'' +
                                    ", streak='" + streak + '\'' +
                                    ", team_id='" + team_id + '\'' +
                                    ", team_logo='" + team_logo + '\'' +
                                    ", team_name='" + team_name + '\'' +
                                    ", win_lost='" + win_lost + '\'' +
                                    ", win_rate='" + win_rate + '\'' +
                                    '}';
                        }
                    }

                    @Override
                    public String toString() {
                        return "DataBean{" +
                                "fs_A=" + fs_A +
                                ", fs_B=" + fs_B +
                                ", show=" + show +
                                ", team_A_id=" + team_A_id +
                                ", team_A_logo='" + team_A_logo + '\'' +
                                ", team_A_name='" + team_A_name + '\'' +
                                ", team_A_rank=" + team_A_rank +
                                ", team_B_id=" + team_B_id +
                                ", team_B_logo='" + team_B_logo + '\'' +
                                ", team_B_name='" + team_B_name + '\'' +
                                ", team_B_rank=" + team_B_rank +
                                ", winner='" + winner + '\'' +
                                ", end=" + end +
                                ", name='" + name + '\'' +
                                ", top=" + top +
                                ", data=" + data +
                                ", header=" + header +
                                '}';
                    }
                }

                @Override
                public String toString() {
                    return "ContentBean{" +
                            "name='" + name + '\'' +
                            ", data=" + data +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "RoundsBean{" +
                        "content=" + content +
                        ", template='" + template + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ContentBeanX{" +
                    "description='" + description + '\'' +
                    ", rounds=" + rounds +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DataStandingBean{" +
                "template='" + template + '\'' +
                ", content=" + content +
                '}';
    }
}
