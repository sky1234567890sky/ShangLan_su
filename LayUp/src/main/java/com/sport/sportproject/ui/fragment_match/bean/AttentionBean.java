package com.sport.sportproject.ui.fragment_match.bean;

import java.util.List;

/**
 * Created by 华为 on 2019/7/5.
 */
//关注
public class AttentionBean {

    /**
     * list : []
     * prev :
     * next :
     * has_prev : false
     * has_next : false
     */

    private String prev;
    private String next;
    private boolean has_prev;
    private boolean has_next;
    private List<?> list;

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public boolean isHas_prev() {
        return has_prev;
    }

    public void setHas_prev(boolean has_prev) {
        this.has_prev = has_prev;
    }

    public boolean isHas_next() {
        return has_next;
    }

    public void setHas_next(boolean has_next) {
        this.has_next = has_next;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
