# Divananda Application

Project ini berfokus pada pengenalan Array dan menampilkan Array.

`Array.asList` digunakan untuk membuat Array baru.

`onCreateViewHolder()` digunakan untuk menginisialisasi Viewholder dan view. Contoh :
```
  @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_row,parent, false);
        return new PokemonViewHolder(view);
    }
```
Kode diatas mengembalikan sebuah viewholder bernama PokemonViewHolder dengan view bernama layout.pokemon_row.

`onBindViewHolder()`digunakan untuk mengambil data yang sesuai dan menampilkan data tersebut. Seperti kode dibawah ini :
```
  @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon current = pokemons.get(position);
        holder.textView.setText(current.getName());
        holder.containerView.setTag(current);
    }
```

`getItemCount()` digunakan untuk mendapatkan jumlah data.
