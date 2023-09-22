package com.udangoreng.divanandaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView nameTextView, numberTextView;
    private ImageView pokeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra(PokemonAdapter.EXTRA_NAME);
        String number = intent.getStringExtra(PokemonAdapter.EXTRA_NUMBER);
        int img = intent.getIntExtra("images", 0);
        nameTextView = (TextView) findViewById(R.id.namePoke);
        numberTextView = (TextView) findViewById(R.id.numberPoke);
        pokeImageView = (ImageView) findViewById(R.id.imagePoke);
        pokeImageView.setImageResource(img);
        nameTextView.setText(name);
        numberTextView.setText(number);
    }

    public void done(){
        finish();
    }
}