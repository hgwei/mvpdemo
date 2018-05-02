package com.hgw.mvpdemo.presenter;

import android.os.Handler;

import com.hgw.mvpdemo.base.BasePresenter;
import com.hgw.mvpdemo.contract.MainContract;


/**
 * 描述：MainActivity Presenter
 * @author hgw
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    /**
     * 获取登录数据
     * */
    @Override
    public void getLoginData(final String account, String password) {
        //回调View，展示加载框
        mView.showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //回调View，关闭加载框
                mView.hideLoading();
                //回调View，处理登录结果
                mView.showLoginData("用户："+account+"登录成功");
            }
        }, 2000);

    }
}
