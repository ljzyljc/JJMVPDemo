package com.example.tempcw.jjmvpdemo.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.tempcw.jjmvpdemo.mvp.presenter.impl.AbsBasePresenter;
import com.example.tempcw.jjmvpdemo.mvp.view.IBaseView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TempCw on 2017/4/18.
 * 当一个fragment中有多个Presenter使用Map来管理
 */

public abstract class AbsBaseMapFragment extends AbsBaseFragment{

    private Map<AbsBasePresenter,IBaseView> map;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        map=new HashMap<>();
    }
    public void putPresenter(AbsBasePresenter presenter,IBaseView baseView){
        presenter.attachView(baseView);
        map.put(presenter,baseView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (map!=null){
            for (AbsBasePresenter presenter:map.keySet()){
                presenter.detachView();
            }
        }
        map=null;
    }
}
