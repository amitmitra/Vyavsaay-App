package com.vyavsaay;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/*
* Author: Amit Mitra
 */


public class MainActivity extends ActionBarActivity {

    private Activity mActivity;
    private Context mContext;
    private WebView vyavsaayWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        super.onCreate(savedInstanceState);

        mActivity = this;
        mContext = this;

        //WebView vyavsaayWebView = new WebView(this);
        setContentView(R.layout.activity_main);
        vyavsaayWebView = (WebView)findViewById(R.id.vyavsaay_webview);

        WebSettings settings = vyavsaayWebView.getSettings();

        //settings.setJavaScriptEnabled(true);
        //settings.setDomStorageEnabled(true);
        //settings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
        //settings.setUseWideViewPort(true);
        //settings.setLoadWithOverviewMode(true);
        //vyavsaayWebView.canGoBack();

        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        vyavsaayWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        vyavsaayWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        vyavsaayWebView.setFilterTouchesWhenObscured(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);

        settings.setUseWideViewPort(true);

        settings.setLoadWithOverviewMode(true);
        vyavsaayWebView.setBackgroundColor(0);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        vyavsaayWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        vyavsaayWebView.loadUrl("https://vyavsaay.com/");

        vyavsaayWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int progress) {
                mActivity.setProgress(progress * 1000);
            }
        });

        vyavsaayWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(mActivity, "There is some problem opening this page! Please Try Again!" + description, Toast.LENGTH_SHORT).show();
            }

            /*@Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                view.loadUrl("https://vyavsaay.com/");
                return true;
            }*/
        });
    }
}
