package com.example.tempcw.jjmvpdemo.mvp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tempcw.jjmvpdemo.mvp.presenter.impl.AbsBasePresenter;
import com.example.tempcw.jjmvpdemo.mvp.view.IBaseView;

/**
 * Created by TempCw on 2017/4/18.
 * 当一个Fragment中只有一个Presenter
 */

public abstract class AbsBaseFragment<P extends AbsBasePresenter,V extends IBaseView> extends BaseFragment{
    private P presenter;

    private View contentView;

    private boolean isInit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (contentView==null){
            contentView=inflater.inflate(bindLayoutId(),container,false);
            initContentView(contentView);
        }
        //移除父布局
        ViewGroup parent= (ViewGroup) contentView.getParent();
        if (parent!=null){
            parent.removeView(contentView);
        }
        return contentView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter==null) {
            this.presenter = bindPresenter();
        }
        //绑定视图
        if (presenter!=null){
            presenter.attachView(bindView());
        }
        if (!isInit){
            this.isInit=true;
            initData();
        }


    }

    @Override
    public Context getContext() {
        return super.getContext();
    }
    //初始化数据
    public abstract void initData();

    public abstract P bindPresenter();

    public abstract V bindView();

    public abstract int bindLayoutId();

    public abstract void initContentView(View contentView);

    public P getPresenter() {
        return presenter;
    }

    public View getContentView() {
        return contentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.presenter!=null){
            this.presenter.detachView();
            this.presenter=null;
        }
    }
}
