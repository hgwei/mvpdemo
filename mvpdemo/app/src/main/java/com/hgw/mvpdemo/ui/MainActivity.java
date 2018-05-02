package com.hgw.mvpdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.hgw.mvpdemo.R;
import com.hgw.mvpdemo.base.BaseActivity;
import com.hgw.mvpdemo.contract.MainContract;
import com.hgw.mvpdemo.presenter.MainPresenter;

/**
 * 描述：首页
 * @author hgw
 */

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View ,View.OnClickListener{
    private Button mlogin;
    private TextView mloginSuccessText;

    /**
     * 入口
     * @param context
     */
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initPresenter() {
        mPresenter=new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mlogin= (Button) findViewById(R.id.login);
        mlogin.setOnClickListener(this);
        mloginSuccessText= (TextView) findViewById(R.id.loginSuccessText);
    }

    @Override
    public void showLoginData(String response) {
        mlogin.setVisibility(View.GONE);
        mloginSuccessText.setVisibility(View.VISIBLE);
        mloginSuccessText.setText(response);
        showShortToast("登录成功");
    }


    @Override
    public void showLoading() {
        showProgressDialog("正在登陆中...");
    }

    @Override
    public void hideLoading() {
        hideProgressDialog();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                /**登录*/
                mPresenter.getLoginData("aa","123456");
                break;

            default:
                break;
        }
    }

}
