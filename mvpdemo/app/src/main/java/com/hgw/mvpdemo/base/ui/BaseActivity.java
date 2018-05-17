package com.hgw.mvpdemo.base.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hgw.mvpdemo.base.mvp.AbstractPresenter;
import com.hgw.mvpdemo.base.mvp.BaseView;

/**
 * 描述：MVP模式的Base Activity
 * @author hgw
 */
public abstract class BaseActivity<T extends AbstractPresenter> extends AppCompatActivity implements BaseView {
    protected T mPresenter;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Presenter的初始化（如果熟悉Dagger2，使用依赖注入关键字@Inject就不用这么麻烦了）
        initPresenter();
        // Presenter和View（Activity、Fragment）生命周期绑定，防止内存泄漏
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        //Presenter和View（Activity、Fragment）生命周期解除绑定，防止内存泄漏
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**显示短时间的Toast*/
    public void showShortToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    /**显示长时间的Toast*/
    public void showLongToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    /**显示progressDialog*/
    public void showProgressDialog(String message) {
        mProgressDialog =  ProgressDialog.show(this, null, message, false);
    }

    /**关闭progressDialog*/
    public void hideProgressDialog() {
        if(mProgressDialog!=null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    /**Presenter初始化的抽象接口*/
    protected abstract void  initPresenter();

}
