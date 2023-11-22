package com.udangoreng.divanandasavedinstance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText num1, num2, hasil;
    private TextView benar;
    Integer angka1, angka2, jawab, jawaban;
    boolean isClicked = false;
    String keterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        hasil = findViewById(R.id.hasil);
        benar = findViewById(R.id.textView2);

        benar.setVisibility(View.VISIBLE);

        if(savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean("isVisible");
            if(isVisible){
                isClicked = isVisible;
                keterangan = savedInstanceState.getString("bs");
                benar.setText(keterangan);
            }
        }
    }

    public void cekHasil(View view){
        if(TextUtils.isEmpty(String.valueOf(num1.getText())) || TextUtils.isEmpty(String.valueOf(num2.getText())) || TextUtils.isEmpty(String.valueOf(hasil.getText()))) {
            Toast.makeText(getApplicationContext(), "Tolong Masukkan Angka!", Toast.LENGTH_SHORT).show();
        } else {
            angka1 = Integer.valueOf(String.valueOf(num1.getText()));
            angka2 = Integer.valueOf(String.valueOf(num2.getText()));
            jawab = Integer.valueOf(String.valueOf(hasil.getText()));
            jawaban = angka1 + angka2;
            if (jawab == jawaban) {
                isClicked = true;
                keterangan = "Benar";
                Toast.makeText(getApplicationContext(), "Benar", Toast.LENGTH_SHORT).show();
                benar.setVisibility(View.VISIBLE);
                benar.setText("Benar");
            } else {
                isClicked = true;
                keterangan = "Salah";
                Toast.makeText(getApplicationContext(), "Salah", Toast.LENGTH_SHORT).show();
                benar.setVisibility(View.VISIBLE);
                benar.setText("Salah");
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(isClicked){
            outState.putString("bs", keterangan);
            outState.putBoolean("isVisible", true);
        }
    }
}