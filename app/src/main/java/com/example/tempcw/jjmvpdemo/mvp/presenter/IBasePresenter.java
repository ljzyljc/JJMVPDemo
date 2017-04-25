package com.example.tempcw.jjmvpdemo.mvp.presenter;

import com.example.tempcw.jjmvpdemo.mvp.view.IBaseView;

/**
 * Created by TempCw on 2017/4/18.
 */

public interface IBasePresenter<V extends IBaseView> {
    void attachView(V view);

    void detachView();
}
