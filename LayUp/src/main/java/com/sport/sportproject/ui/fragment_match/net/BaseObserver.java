package com.sport.sportproject.ui.fragment_match.net;
import java.util.logging.Logger;
import io.reactivex.Observer;
/**
 * Created by $lzj on 2019/5/6.
 */
public abstract class BaseObserver<T> implements Observer<T> {
    private final String Tag = getClass().getName();
    @Override
    public void onComplete() {
//        Logger.logD(Tag,"onComplete:");
    }
    @Override
    public void onError(Throwable e) {
//        Logger.logD(Tag,"onError:" +e.getMessage());
    }
}
