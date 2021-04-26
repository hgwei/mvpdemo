package com.hgw.mvpdemo.ui.main.presenter;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.hgw.mvpdemo.app.MvpDemoApp;
import com.hgw.mvpdemo.base.mvp.BasePresenter;
import com.hgw.mvpdemo.ui.main.contract.SplashContract;


/**
 * 描述：SplashActivity Presenter
 * @author hgw
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    @Override
    public void start(View view) {
        //首次打开，才出现启动页
        if(MvpDemoApp.isFirstRun){
            MvpDemoApp.isFirstRun = false;
            startAnimation(view);
        }else{
            mView.toMain();
        }
    }

    public void startAnimation(View view) {
        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f);
        aa.setDuration(2000);
        view.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {
                mView.toMain();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }
}
