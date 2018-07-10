package com.hgw.mvpdemo.ui.main.contract;

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
         * 回调View，跳转首页
         * */
        void toMain();
    }


    /** 定义操作Presenter层业务处理的接口 */
    interface Presenter extends AbstractPresenter<View> {

        /**
         * 业务判断
         * */
        void start(android.view.View view);

    }

}
