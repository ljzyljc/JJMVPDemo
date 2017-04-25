package com.example.tempcw.jjmvpdemo.mvp.presenter.impl;

import android.content.Context;

import com.example.tempcw.jjmvpdemo.mvp.model.IBaseModel;
import com.example.tempcw.jjmvpdemo.mvp.presenter.IBasePresenter;
import com.example.tempcw.jjmvpdemo.mvp.view.IBaseView;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by TempCw on 2017/4/18.
 * 弱引用
 * 用弱引用去持有对象，当这个对象一旦被释放（或者置为空），它就会自动释放
 */

public abstract class AbsBasePresenter<M extends IBaseModel,V extends IBaseView> implements IBasePresenter<V> {
    private V proxy;
    private WeakReference<Context> weakContext;
    private WeakReference<V> weakView;

    public AbsBasePresenter(Context context){
        this.weakContext=new WeakReference<Context>(context);
    }

    public Context getContext(){
        return weakContext.get();
    }

    private M model;

    public M bindModel(){
        return model;
    }

    public M getModel() {
        this.model=bindModel();
        return model;
    }

    public V getView(){
        //这个时候应该返回代理对象
        return proxy;
    }
    /**
     * 用于检测View是否为空对象
     * @return
     */
    public boolean isAttachView(){
        if (this.weakView!=null&&this.weakView.get()!=null){
            return true;
        }
        return false;
    }


    @Override
    public void attachView(V view) {
        this.weakView=new WeakReference<V>(view);
        MvpViewInvocationHandler handler=new MvpViewInvocationHandler(this.weakView.get());
        //在这里采用动态代理
        proxy= (V) Proxy.newProxyInstance(view.getClass().getClassLoader(),
                view.getClass().getInterfaces(),
                handler);

    }

    @Override
    public void detachView() {
        if (this.weakView!=null){
            this.weakView.clear();
            this.weakView=null;
        }
    }
    private class MvpViewInvocationHandler implements InvocationHandler{
        //目标对象
        private IBaseView baseView;

        public MvpViewInvocationHandler(IBaseView baseView){
            this.baseView=baseView;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (isAttachView()){
                return method.invoke(baseView,args);
            }
            return null;
        }
    }



}
