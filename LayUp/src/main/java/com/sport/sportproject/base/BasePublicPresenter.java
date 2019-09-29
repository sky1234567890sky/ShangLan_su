package com.sport.sportproject.base;
public class BasePublicPresenter extends BasePresenter implements PublicView, PublicPresenter {
    /**
     * @param type    区分
     * @param objects
     */
    @Override
    public void onSuccess(int type, Object... objects) {
        if (getView() != null) {
            getView().onSuccess(type, objects);
        }
    }
    /**
     * @param e 错误
     */
    @Override
    public void onFaile(Throwable e) {
        if (getView() != null) {
            getView().onFaile(e);
        }
    }
    /**
     * @param type    区分
     * @param objects 可变参数
     */

    @Override
    public void getData(int type, Object... objects) {
        if (getModel() != null) {
            getModel().getData(this, type, objects);
        }
    }
}
