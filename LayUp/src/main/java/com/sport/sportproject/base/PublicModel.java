package com.sport.sportproject.base;
/**
 * 苏克阳 实训进阶
 */
public interface PublicModel<T> {

    void getData(PublicView view, int type,T... ts);
}