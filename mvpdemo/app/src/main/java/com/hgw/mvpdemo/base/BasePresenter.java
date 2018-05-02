package com.hgw.mvpdemo.base;

/**
 * 描述：Presenter 基类（定义一些Presenter层共用的接口方法）
 * @author hgw
 */
public class BasePresenter<T extends BaseView> implements AbstractPresenter<T> {
    protected T mView;

    public BasePresenter() {
    }

    /** Presenter和View（Activity、Fragment）生命周期绑定，防止内存泄漏*/
    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    /** Presenter和View（Activity、Fragment）生命周期解除绑定，防止内存泄漏*/
    @Override
    public void detachView() {
        this.mView = null;
    }

}
