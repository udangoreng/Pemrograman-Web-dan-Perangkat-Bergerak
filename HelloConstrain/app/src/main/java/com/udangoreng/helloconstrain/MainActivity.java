package com.udangoreng.helloconstrain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private boolean isPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        if (isPressed == false) {
            Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_message, Toast.LENGTH_LONG);
            toast.show();
            isPressed = true;
        }
    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void reset(View view) {
//        mCount =0;
//        mShowCount.setText(Integer.toString(mCount));
        mCount--;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}