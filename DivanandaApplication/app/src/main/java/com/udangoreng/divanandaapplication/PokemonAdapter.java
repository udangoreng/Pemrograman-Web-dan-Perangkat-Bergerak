package com.udangoreng.divanandaapplication;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

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
                    intent.putExtra(EXTRA_NAME, current.getName());
                    intent.putExtra(EXTRA_NUMBER, Integer.toString(current.getNumber()));
                    intent.putExtra("images",current.getImg());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    //Membuat Array
    private List<Pokemon> pokemons = Arrays.asList(
            new Pokemon("Ditto", 1, R.drawable.ditto),
            new Pokemon("Pikachu", 2, R.drawable.pikachu),
            new Pokemon("Bulbasaur", 3, R.drawable.bulbasaur)
    );

    // Memanggil Recycle View
    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_row,parent, false);
        return new PokemonViewHolder(view);
    }

    // Menampilkan Array
    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon current = pokemons.get(position);
        holder.textView.setText(current.getName());
        holder.containerView.setTag(current);
    }

    // Menghitung Jumlah Data dalam Array
    @Override
    public int getItemCount() {
        return pokemons.size();
    }


}
