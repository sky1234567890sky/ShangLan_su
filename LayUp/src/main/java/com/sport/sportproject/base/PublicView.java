package com.sport.sportproject.base;
/**
 * 苏克阳 实训进阶
 */
public interface PublicView<S> {
    /**
     * @param type 区分
     * @param s 可变请求参数
     */
    void onSuccess(int type,S... s);

    /**
     *  错误
     * @param e
     */
    void onFaile(Throwable e);
}
