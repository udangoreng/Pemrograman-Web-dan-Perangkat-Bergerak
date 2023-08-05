package com.udangoreng.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    //Menambahkan EXTRA untuk intent
    public static  final String EXTRA_MESSAGE = "com.example.android.twoactivity.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private TextView mReplyHead;
    private TextView mReplyTextView;

    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = (EditText) findViewById(R.id.editText_main);
        mReplyHead = (TextView) findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked");
        //Membuat intent baru
        Intent intent = new Intent(this, SecondActivity.class);

        String message = mMessageEditText.getText().toString();
        //Mengisi Extra untuk intent
        intent.putExtra(EXTRA_MESSAGE, message);
        //Memulai aktivitas dengan intent dan mendapatkan balasan
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        //Mengecek untuk mendapatkan intent yang benar
        if (requestCode == TEXT_REQUEST){
            //Memastikan permintaan sukses
            if (resultCode == RESULT_OK){
                //Mendapatkan data balasan dari intent
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHead.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}