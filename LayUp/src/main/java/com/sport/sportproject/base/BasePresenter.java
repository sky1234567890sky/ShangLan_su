package com.sport.sportproject.base;

import java.lang.ref.WeakReference;
/**
 * 苏克阳 实训进阶
 */
public class BasePresenter<V extends PublicView,M extends PublicModel> {

    protected WeakReference<V> mView;
    protected WeakReference<M> mModel;
    /**
     * @param view V层
     * @param model M层
     */
    public void attachView(V view, M model) {
        this.mView = new WeakReference<>(view);
        this.mModel = new WeakReference<>(model);
    }
    /**
     * @return V层
     */
    public V getView(){
        return mView != null ? mView.get():null;
    }
    /**
     * @return M层
     */
    public M getModel(){
        return mModel != null ? mModel.get() : null;
    }
    public void destroy() {
        if (mModel != null) {
            mModel.clear();
        }
        if (mView != null) {
            mView.clear();
            mView = null;
        }
    }
}
