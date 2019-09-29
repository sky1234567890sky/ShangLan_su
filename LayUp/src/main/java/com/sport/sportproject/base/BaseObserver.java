package com.sport.sportproject.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver implements Observer {
    private Disposable mD;
    @Override
    public void onSubscribe(Disposable d) {
        mD = d;
    }
    /**
     *  Request Success abstract method
     * @param o
     */
    @Override
    public void onNext(Object o) {
        OnSuccess(o);
        dispon();
    }
    /**
     *  Request Error abstract method
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        onFailer(e);
        dispon();
    }
    @Override
    public void onComplete() {
    }
    protected abstract void OnSuccess(Object o);

    private void dispon() {
        if (mD != null && !mD.isDisposed()) {
            mD.dispose();
        }
    }
    protected abstract void onFailer(Throwable e);
}
