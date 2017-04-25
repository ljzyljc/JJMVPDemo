package com.example.tempcw.jjmvpdemo.mvp.view;

/**
 * Created by TempCw on 2017/4/18.
 * 基础View   提供两个基本方法，加载成功或者失败
 *
 */

public interface IBaseView<T> {
    void success(T t);
    void failed(String s);

}
