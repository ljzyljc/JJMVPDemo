package com.example.tempcw.jjmvpdemo.mvp.view;

/**
 * Created by TempCw on 2017/4/18.
 * 加载成功或者失败后显示动画或toast
 */

public interface ILceView<M> extends IBaseView{

    /**
     * 是否显示loading（加载中）图片
     * @param isPulltoRefresh
     */
    void showLoading(boolean isPulltoRefresh);

    /**
     * 显示视图
     */
    void showContent();

    /**
     * 加载出错
     * @param e
     * @param isPullToRefresh
     */
    void showError(Exception e,boolean isPullToRefresh);

    /**
     * 绑定数据
     * @param data
     */
    void showData(M data);


}
