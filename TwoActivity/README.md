# Two Activities

Project ini dikerjakan pada tanggal 1 Agustus 2023. Project ini berfokus pada pengenalan Dua Aktivitas berbeda dan memgirimkan variabel ke activity tersebut.

## Catatan

Untuk membuat aktivitas berbeda, dapat menggunakan File > New > Activity > Empty View Activity. Centang pada Generate Layout File, lalu klik finsih. Sebuah Layout dan Activity baru akan dibuat.

Pada AndroidManifest.xml, ubah activity yang ditambahkan dengan menambah `android:label`, `android:parentActivityName`, dan tag `<meta-data` yang akan memiliki atribut `android:name` dan `android:value` sehingga kode menjadi :
```
  <activity android:name=".SecondActivity"
            android:exported="false"
            android:label="Second Activity"
            android:parentActivityName=".MainActivity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".MainActivity"/>
    </activity>
```
Untuk mengaktifkan aktivitas kedua dengan klik, dapat menggnakan suatu Intent. Pada function launchSecondActivity, tambahkan
<pre><code>Intent intent = new Intent(this, SecondActivity.class);
startActivity(intent);</code>code></pre>
Intent membutuhkan dua argumen yaitu Konteks aplikas (this), dan komponen yang akan menerima intent tersebut. Untuk menjalankan, gunakan `startActivity(intent);`

Untuk meneruskan data ke aktivitas lain, dapat menggunakan ekstra intent. Ekstra intent harus dideklarasikan terlebih dulu dengan :
```
public static final String EXTRA_MESSAGE =
"com.example.android.twoactivities.extra.MESSAGE";
```
Setelah itu, tambahkan data yang ingin dimasukkan dengan menggunakan `intent.putExtra` dengan EXTRA_NAME sebagai kunci dan variableName sebagai nilai.
```
intent.putExtra(EXTRA_MESSAGE, message);
```
Untuk mendapatkan intent dari aktivitas lain, dapat menggunakan `Intent intent = getIntent();` yang ditambahkan pada metode onCreate. Data dari intent tersebut dapat diambil dengan menggunakan `intent.getStringExtra(MainActivity.EXTRA_MESSAGE);`.

Untuk menutup aktivitas dan kembali ke aktivitas utama dapat menggunakan `finish();`
