package com.hgw.mvpdemo.presenter;

import android.os.Handler;
import com.hgw.mvpdemo.base.BasePresenter;
import com.hgw.mvpdemo.contract.SplashContract;


/**
 * 描述：SplashActivity Presenter
 * @author hgw
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    /**
     * 执行延时2秒，然后跳转页面
     * */
    @Override
    public void delayToMain() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //回调到View层，执行页面跳转
                mView.jumpToMain();
            }
        }, 2000);
    }
}
