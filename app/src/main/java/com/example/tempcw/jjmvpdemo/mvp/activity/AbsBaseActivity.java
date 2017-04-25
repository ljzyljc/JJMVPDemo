package com.example.tempcw.jjmvpdemo.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.tempcw.jjmvpdemo.mvp.presenter.impl.AbsBasePresenter;
import com.example.tempcw.jjmvpdemo.mvp.view.IBaseView;

/**
 *
 * 当一个Activity中只有一个Presenter
 */

public abstract class AbsBaseActivity<P extends AbsBasePresenter,V extends IBaseView> extends BaseActivity {
    private P presenter;
    private V view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter==null){
            presenter=bindPresenter();
        }
        if (view==null){
            this.presenter.attachView(bindView());
        }
    }

    public abstract P bindPresenter();

    public abstract V bindView();

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.presenter!=null){
            this.presenter.detachView();
            this.presenter=null;
        }
    }
}
