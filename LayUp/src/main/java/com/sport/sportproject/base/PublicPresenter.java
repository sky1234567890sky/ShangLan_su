package com.sport.sportproject.base;
/**
 * 苏克阳 实训进阶
 */
public interface PublicPresenter<T> {
    void getData(int type,T... ts);//可变参
}
