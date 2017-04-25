package com.example.tempcw.jjmvpdemo.mvp.model.impl;

import android.content.Context;

import com.example.tempcw.jjmvpdemo.mvp.model.IBaseModel;

/**
 * Created by TempCw on 2017/4/18.
 */

public abstract class AbsBaseModel implements IBaseModel {
    private Context context;

    //构造器需要一个context参数
    public AbsBaseModel(Context context){
        this.context=context;
    }

    public Context getContext() {
        return context;
    }
}
