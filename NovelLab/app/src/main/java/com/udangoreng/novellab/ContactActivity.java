package com.udangoreng.novellab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.content.Intent;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.loadUrl("https://github.com/udangoreng");
        Intent intent = getIntent();
        int getThatUrl = intent.getIntExtra("url", 0);

        if (getThatUrl==R.id.github) {
            webView.loadUrl("https://github.com/udangoreng");
        } else if (getThatUrl == R.id.whatsapp) {
            webView.loadUrl("https://wa.me/6282143630209");
            finish();
        }
    }
}