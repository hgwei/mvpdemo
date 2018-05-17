package com.hgw.mvpdemo.ui;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.hgw.mvpdemo.R;
import com.hgw.mvpdemo.app.MvpDemoApp;
import com.hgw.mvpdemo.base.ui.BaseActivity;
import com.hgw.mvpdemo.contract.SplashContract;
import com.hgw.mvpdemo.presenter.SplashPresenter;

/**
 * 描述：启动页
 * @author hgw
 */

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    @Override
    protected void initPresenter() {
        mPresenter=new SplashPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //设置窗口全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final View view = View.inflate(this, R.layout.activity_splash, null);
        setContentView(view);

        //首次打开，才出现启动页
        if(MvpDemoApp.isFirstRun){
            MvpDemoApp.isFirstRun = false;
            mPresenter.startAnimation(view);
        }else{
            jumpToMain();
            return;
        }
    }

    @Override
    public void jumpToMain() {
        MainActivity.toActivity(this);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}
