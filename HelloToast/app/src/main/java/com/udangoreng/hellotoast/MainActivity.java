package com.udangoreng.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    //Mendeklarasikan variable int mCount
    private TextView mShowCount;
    //Mendeklarasikan TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        //Memanggil sebuah textView dengan id show_count sebagai MShowCount

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_message, Toast.LENGTH_LONG);
        //Memanggil dan membuat suatu Toast dengan nama toast.
        //getApplicationContext berfungsi untuk mengambil informasi aplikasi saat ini
        //R.string.toast_message digunakan untuk mengambil string dengan nama toast_message
        //Toast.LENGTH_LONG merupakan durasi dari toast muncul
        toast.show();
        //Menampilkan toast
    }
    //Fungsi untuk menampilkan Toast

    public void countUp(View view) {
        mCount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
            //Set text pada mShowCount dengan mengubah integer mCount menjadi string
        }
    }
    //Fungsi untuk countUp

    public void reset(View view) {
//        mCount =0;
//        mShowCount.setText(Integer.toString(mCount));
        mCount--;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}