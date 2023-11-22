# SavedInstance

Project ini mengenalkan mengenai siklus hidup dan savedInstance.

Untuk menambahkan suatu data ke dalam savedInstance dapat menggunakan : 
```
  @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(isClicked){
            outState.putString("bs", keterangan);
            outState.putBoolean("isVisible", true);
        }
    }
```

Dan untuk mengambil sebuah data dari savedInstance menggunakan :
```
   if(savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean("isVisible")
            if(isVisible){
                isClicked = isVisible;
                keterangan = savedInstanceState.getString("bs");
                benar.setText(keterangan);
            }
        }
```
