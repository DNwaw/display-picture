package com.dnwaw.displaypicture;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView mWebView;
    private int state = 0;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        //  The initial zoom setting is 30%, which is also the minimum zoom level allowed.
        mWebView.setInitialScale(30);

        mWebView.setLayerType(WebView.LAYER_TYPE_HARDWARE, null);

        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);//  To make it cleaner.

        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl("file:///android_asset/main.html");
    }

    @Override
    public void onBackPressed() {
        if (state == 0) {
            mWebView.loadUrl("https://bing.com");
            state = 1;
        } else{
            mWebView.loadUrl("file:///android_asset/main.html");
            state = 0;
        }
    }
}
