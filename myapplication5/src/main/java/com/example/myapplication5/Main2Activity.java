package com.example.myapplication5;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    private WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        wb = (WebView) findViewById(R.id.wb);
        wb.loadUrl("https://baidu.com");
        wb.setWebViewClient(new WebViewClient());
        wb.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
    }
}
