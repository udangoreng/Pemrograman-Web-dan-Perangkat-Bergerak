package com.udangoreng.projectbangunruang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.TemperatureControlTemplate;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private TextView inputSisi;

    private Float sisi;
    private Float volume;
    private Float luasBangun;

    private Float luasSisi;
    private String v;
    private String l;
    private String ls;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        inputSisi = (TextView) findViewById(R.id.panjangSisi);

        //Mendapatkan intent dari aktivitas sebelumnya
        Intent intent = getIntent();
        String panjangSisi = intent.getStringExtra(MainActivity.EXTRA_SISI);
        inputSisi.setText(panjangSisi);

        //Mengubah intent yang berupa string menjadi float
        sisi = Float.parseFloat(panjangSisi);

        //Rumus menghitung
        volume = sisi * sisi * sisi;
        luasBangun = 6 * (sisi * sisi);
        luasSisi = sisi * sisi;

        TextView textVolume = (TextView) findViewById(R.id.volume);
        TextView textLuas = (TextView) findViewById(R.id.luas);
        TextView textSisi = (TextView) findViewById(R.id.luasSisi);

        textVolume.setText(Float.toString(volume));
        textLuas.setText(Float.toString(luasBangun));
        textSisi.setText(Float.toString(luasSisi));


    }
}