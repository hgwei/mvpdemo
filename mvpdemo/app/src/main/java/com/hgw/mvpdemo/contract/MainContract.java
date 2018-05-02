package com.hgw.mvpdemo.contract;

import com.hgw.mvpdemo.base.AbstractPresenter;
import com.hgw.mvpdemo.base.BaseView;

/**
 * 描述：契约类-定义MainActivity页面所需view和presenter的接口
 * @author hgw
 */

public interface MainContract {

    /** 定义操作View层的接口 */
    interface View extends BaseView {
        /**
         * 回调View，登录结果返回
         * */
        void showLoginData(String response);
    }

    /** 定义操作Presenter层业务处理的接口 */
    interface Presenter extends AbstractPresenter<View> {
        /**
         * 获取登录数据
         * @param account 账号
         * @param password 密码
         */
        void getLoginData(String account, String password);

    }

}
