package com.udangoreng.divanandaapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new PokemonAdapter();
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


//        List<Pokemon> pokemons = new ArrayList<>();
//        pokemons.add(new Pokemon("Zeus", 1));
//        pokemons.add(new Pokemon("Pikachu", 2));
//        pokemons.add(new Pokemon("Bonanza", 3));
//
//        List<String> students = Arrays.asList("Aksa", "Aska", "Bagus");
//        Map<String, Pokemon> assignments = new HashMap<>();
//        Random random = new Random();
//
//        for(String student : students){
//            int index = random.nextInt(pokemons.size());
//            assignments.put(student, pokemons.get(index));
//        }
//
//        for (Map.Entry<String, Pokemon> entry:assignments.entrySet()){
//            Pokemon pokemon = entry.getValue();
//            Log.d("Itu", entry.getKey() + " Temannya "+ pokemon.getName());
//        }
        }
}