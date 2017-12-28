package com.ssc2018.dqb.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ssc2018.dqb.R;

/**
 * 作者：MrXu on 2017/12/27 10:14
 * 邮箱：17610872621@163.com
 */
public class ZhiBoWebActivity extends Activity {
    private WebView webViews;
    private ImageView back;
    private TextView title;
    private ProgressBar progressBar;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
    }
    public void initData() {
        url = getIntent().getStringExtra("url");
        title.setText(getIntent().getStringExtra("title"));
        if (url != null) {
            webViews.loadUrl(url);
        } else {
            finish();
        }
    }
    public void findView(){
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        title = (TextView) findViewById(R.id.title);
        back = (ImageView) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        webViews = (WebView) findViewById(R.id.webViews);
        webViews.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViews.getSettings().setUseWideViewPort(true);
        webViews.getSettings().setJavaScriptEnabled(true);
        webViews.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!(url.startsWith("http://") || url.startsWith("https://"))) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                view.loadUrl(url);
                return true;
            }

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

        });
        webViews.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                // ZhiBoWebActivity.this.title.setText(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
        initData();


    }

    public int getContentView(){
        return R.layout.activity_basket_zhibo_webview;

    }
}
