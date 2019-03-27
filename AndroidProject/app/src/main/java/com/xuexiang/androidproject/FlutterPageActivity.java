package com.xuexiang.androidproject;

import android.os.Bundle;

import io.flutter.app.FlutterActivity;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;

/**
 * @author xuexiang
 */
public class FlutterPageActivity extends FlutterActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FlutterMain.startInitialization(this);
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);
        getFlutterView().setInitialRoute("flutterView");


        registerPlugins(getFlutterView());

    }

    /**
     * 注册插件
     *
     * @param flutterView
     */
    private void registerPlugins(FlutterView flutterView) {


    }
}
