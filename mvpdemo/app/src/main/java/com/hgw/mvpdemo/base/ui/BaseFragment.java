package com.hgw.mvpdemo.base.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.hgw.mvpdemo.base.mvp.AbstractPresenter;
import com.hgw.mvpdemo.base.mvp.BaseView;

/**
 * 描述：MVP模式的Base Fragment
 * @author hgw
 */
public abstract class BaseFragment<T extends AbstractPresenter> extends Fragment implements BaseView {
    protected T mPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //为页面创建Presenter，Presenter的初始化（如果熟悉Dagger2，使用依赖注入关键字@Inject就不用这么麻烦了）
        initPresenter();
        // Presenter和View（Activity、Fragment）生命周期绑定，防止内存泄漏
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Presenter和View（Activity、Fragment）生命周期解除绑定，防止内存泄漏
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    /**显示短时间的Toast*/
    public void showShortToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
    }

    /**显示长时间的Toast*/
    public void showLongToast(String text) {
        Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
    }

    /**显示progressDialog*/
    public void showProgressDialog(String message) {
        mProgressDialog =  ProgressDialog.show(getActivity(), null, message, false);
    }

    /**关闭progressDialog*/
    public void hideProgressDialog() {
        if(mProgressDialog!=null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    /**Presenter初始化的抽象接口*/
    protected abstract void initPresenter();

}
