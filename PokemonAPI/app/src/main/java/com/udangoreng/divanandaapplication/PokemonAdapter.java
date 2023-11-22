package com.udangoreng.divanandaapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>{
    public static final String EXTRA_NAME =
            "com.udangoreng.divanandaapplication.extra.EXTRA_NAME";
    public static final String EXTRA_NUMBER =
            "com.udangoreng.divanandaapplication.extra.EXTRA_NUMBER";

    public class PokemonViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout containerView;
        private TextView textView;
        public PokemonViewHolder(@NonNull View theView) {
            super(theView);
            containerView = theView.findViewById(R.id.pokemon_row);
            textView = theView.findViewById(R.id.pokemon_row_text);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pokemon current = (Pokemon) containerView.getTag();
                    Intent intent = new Intent(view.getContext(), SecondActivity.class);
                    intent.putExtra("url", current.getUrl());
//                    intent.putExtra(EXTRA_NUMBER, Integer.toString(current.getNumber()));
//                    intent.putExtra("images",current.getImg());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    private List<Pokemon> pokemons = new ArrayList<>();
    private RequestQueue requestQueue;

    PokemonAdapter(Context context){
        requestQueue = Volley.newRequestQueue(context);
        loadPokemon();
    }

    public void loadPokemon() {
        String url = "https://pokeapi.co/api/v2/pokemon?limit=50";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray results;
                try {
                    results = response.getJSONArray("results");
                    for (int i = 0; i < results.length(); i++){
                        JSONObject result = results.getJSONObject(i);
                        String name = result.getString("name");
                        pokemons.add(new Pokemon(
                                name.substring(0, 1).toUpperCase() + name.substring(1),
                                result.getString("url")
                        ));
                    }
                    notifyDataSetChanged();
                } catch (JSONException e) {
                    Log.e("ErrAPI", "Error Fetching API", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrAPI", "List Error");
            }
        });
        requestQueue.add(request);
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_row,parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon current = pokemons.get(position);
        holder.textView.setText(current.getName());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }


}