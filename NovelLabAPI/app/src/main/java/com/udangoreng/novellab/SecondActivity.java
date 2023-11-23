package com.udangoreng.novellab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView titleText, writerText, descText, yearText;
    private WebView imageCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        titleText = (TextView) findViewById(R.id.title_textView);
        writerText = (TextView) findViewById(R.id.writer_textView);
        descText = (TextView) findViewById(R.id.description);
        yearText = (TextView) findViewById(R.id.year_textView);
        imageCover = (WebView) findViewById(R.id.imageView2);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String year = intent.getStringExtra("year");
        String writer = intent.getStringExtra("writer");
        String desc = intent.getStringExtra("desc");
        String cover = intent.getStringExtra("image");

        titleText.setText(title);
        writerText.setText(writer);
        descText.setText(desc);
        yearText.setText(year);
        imageCover.loadUrl(cover);
        imageCover.getSettings().setLoadWithOverviewMode(true);
        imageCover.getSettings().setUseWideViewPort(true);
    }
}