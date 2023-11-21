package com.udangoreng.novellab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new NovelAdapter(getApplicationContext());
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if((item.getItemId()) == R.id.about){
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        } else if ((item.getItemId()) == R.id.github) {
            Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ContactActivity.class);
            intent.putExtra("url", item.getItemId());
            startActivity(intent);
        } else if ((item.getItemId()) == R.id.whatsapp) {
        Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("url", item.getItemId());
        startActivity(intent);
        } else if ((item.getItemId()) == R.id.exit) {
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}