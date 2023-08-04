# Two Activities

Project ini dikerjakan pada tanggal 1 Agustus 2023. Project ini berfokus pada pengenalan Dua Aktivitas berbeda dan memgirimkan variabel ke activity tersebut.

## Catatan

Untuk membuat aktivitas berbeda, dapat menggunakan File > New > Activity > Empty View Activity. Centang pada Generate Layout File, lalu klik finsih. Sebuah Layout dan Activity baru akan dibuat.

Pada AndroidManifest.xml, ubah activity yang ditambahkan menjadi 
<pre><code>
  <activity android:name=".SecondActivity"
            android:exported="false"
            android:label="Second Activity"
            android:parentActivityName=".MainActivity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".MainActivity"/>
    </activity>
</code></pre>
Untuk mengaktifkan aktivitas kedua dengan klik, dapat menggnakan suatu Intent. Pada function launchSecondActivity, tambahkan
<pre><code>Intent intent = new Intent(this, SecondActivity.class);
  intentStart();</code></pre>

