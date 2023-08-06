package com.udangoreng.projectbangunruang;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText sisi;
    private TextView test;
    private float panjangSisi;
    public static final String EXTRA_SISI = "com.example.android.projectbangunruang.SISI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sisi = (EditText) findViewById(R.id.panjang);
        test = (TextView) findViewById(R.id.label);
    }

    public void hitung(View view) {
        //Mendapatkan value dari edit text.
        String ukuran = sisi.getText().toString();

        //Mengecek apakah String ukuran kosong
        if(TextUtils.isEmpty(ukuran)) {
            //Menampilkan sebuah toast apabila ukuran kosong
            Toast.makeText(this, "Tolong Masukkan Angka!", Toast.LENGTH_SHORT).show();
        } else {
            //Melanjutkan ke aktivitas kedua saat ukuran tidak kosomg
            Intent intent = new Intent(this, SecondActivity.class);
            String panjangSisi = sisi.getText().toString();
            intent.putExtra(EXTRA_SISI, panjangSisi);
            startActivity(intent);
        }

    }
}