package com.udangoreng.divanandafirstapplication;
//Digunakan untuk mendeklarasikan suatu Package

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//Digunakan Untuk mengimport class yang dibutuhkan seperti AppCombatActicity dan bundle

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Digunakan untuk menghubungkan file activity_main.xml yang berada dalam folder layout
    }
}