package com.hgw.mvpdemo.contract;

import com.hgw.mvpdemo.base.BaseView;
import com.hgw.mvpdemo.base.AbstractPresenter;

/**
 * 描述：契约类-定义SplashActivity页面所需view和presenter的接口
 * @author hgw
 */

public interface SplashContract {

    /** 定义操作View层的接口 */
    interface View extends BaseView {
        /**
         * 回调View，页面跳转
         * */
        void jumpToMain();
    }

    /** 定义操作Presenter层业务处理的接口 */
    interface Presenter extends AbstractPresenter<View> {
        /**
         * 执行延时2秒，然后跳转页面
         */
        void delayToMain();

    }

}
