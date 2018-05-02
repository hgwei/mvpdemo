package com.hgw.mvpdemo.ui;

import android.os.Bundle;
import android.view.WindowManager;
import com.hgw.mvpdemo.R;
import com.hgw.mvpdemo.base.BaseActivity;
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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mPresenter.delayToMain();
    }

    @Override
    public void jumpToMain() {
        MainActivity.toActivity(this);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}
