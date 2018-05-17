package com.hgw.mvpdemo.contract;

import com.hgw.mvpdemo.base.mvp.BaseView;
import com.hgw.mvpdemo.base.mvp.AbstractPresenter;

/**
 * 描述：契约类-定义SplashActivity页面所需view和presenter的接口
 * @author hgw
 */

public interface SplashContract {

    /** 定义操作View层的接口 */
    interface View extends BaseView {

        /**
         * 回调View，跳转MainActivity
         * */
        void jumpToMain();
    }


    /** 定义操作Presenter层业务处理的接口 */
    interface Presenter extends AbstractPresenter<View> {

        /**
         * 启动动画
         * */
        void startAnimation(android.view.View view);

    }

}
