package com.hgw.mvpdemo.base;


/**
 * 描述：View 基类（定义一些View层共用的接口方法）
 * @author hgw
 */
public interface BaseView {

    /**显示加载进度框*/
    void showLoading( );

    /**隐藏加载进度框*/
    void hideLoading( );

}
