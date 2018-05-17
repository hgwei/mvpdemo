package com.hgw.mvpdemo.base.mvp;

/**
 * 描述：Presenter 基类 抽象方法接口
 * @author hgw
 */
public interface AbstractPresenter<T extends BaseView> {

    /**
     * 注入View
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();

}
