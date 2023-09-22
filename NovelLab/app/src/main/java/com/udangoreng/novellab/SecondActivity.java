package com.udangoreng.novellab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView titleText, writerText, descText, yearText;
    private ImageView imageCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        titleText = (TextView) findViewById(R.id.title_textView);
        writerText = (TextView) findViewById(R.id.writer_textView);
        descText = (TextView) findViewById(R.id.description);
        yearText = (TextView) findViewById(R.id.year_textView);
        imageCover = (ImageView) findViewById(R.id.imageView2);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int year = intent.getIntExtra("year", 0);
        String writer = intent.getStringExtra("writer");
        String desc = intent.getStringExtra("desc");
        int cover = intent.getIntExtra("image", 0);

        titleText.setText(title);
        writerText.setText(writer);
        descText.setText(desc);
        yearText.setText(Integer.toString(year));
        imageCover.setImageResource(cover);
    }
}