package com.hgw.mvpdemo.app;

import android.app.Application;

/**
 * 描述：Application
 * @author hgw
 * */
public class MvpDemoApp extends Application {
	private static MvpDemoApp instance;
	public static boolean isFirstRun=true;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static synchronized MvpDemoApp getInstance() {
		return instance;
	}

}