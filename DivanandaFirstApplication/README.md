# Hello World

Project ini adalah tugas pada Hari selasa 25 Juli 2023. Project ini fokus pada pengenalan Android Studio dan menghubungkan antara handphone dan Android Studio.

## Langkah-langkah Menjalankan Physical Device Sebagai Emulator

1. Persiapkan alat berupa Handphone, kabel data / cas, dan perangkat laptop dengan Android Studio yang sudah terinstal
2. Buka Android Studio, buat project baru dengan mengklik File > New > New Project > Empty Views Activity
3. Klik next, lalu isikan data yang diperlukan seperti nama aplikasi, nama package, tempat penyimpanan project, bahasa yang digunakan dan juga SDK minimum yang digunakan.
4. Klik finish, maka aplikasi akan dibuat.
5. Untuk menampiklan aplikasi yang telah dibuat, dapat menggunakan emulator yang telah tersedia di dalam Android Studio tersebut. Namun, apaabila ingin menggunakan Handphone yang dimiliki untuk menampilkan aplikasi tersebut, dapat dimulai dengan mengklik DEvice Manager yang umumnya terdapat di bagian kanan Android Studio.
6. Ada 2 tab pada bagian tersebut. Virtual Devices adalah tab yang digunakan apabila ingin menjalankan dengan emulator yang telah tersedia. Sedangkan tab Physical digunakan apabila ingin menggunakan perangkat luar untuk menjalankan.
7. Untuk menghubungkan, sambungkan kabel data yang telah disiapkan lebih dahulu tersebut. Hubungkan kedua perangkat.
8. Akses Opsi Pengembang yang ada di dalam handphone. Opsi ini umumnya akan muncul setelah pengguna mengakses Mode developer yang dapat di akses dengan cara mengklik bagian nomor versi beberapa kali. Langkah ini umumnya dapat bervariasi sesuai dengan jenis handphone yang dimiliki.
9. Apabila telah berhasil memasuki Mode Developer, akan muncul sebuah opsi pengembang. Klik opsi pengembang tersebut dan cari Debugging USB. Aktifkan opsi tersebut, klik OK apabila terdapat konfirmasi atau permintaan izin.
10. Kembali kepada Android Studio dan lihat pada tab Physical Devices. Apabila Handphone sudah terlihat (misal; SM-12312A) maka koneksi sudah berhasil.
11. Run Aplikasi dengan mengklik :arrow_forward: yang biasanya terdapat di atas kanan, atau dapat juga diakses melalui Run > Run.
12. Tunggu hingga proses selesai. Apabila proses sudah selesai, aplikasi akan secara otomatis terinstall dan terbuka di perangkat tersebut.

## Penjelasan

<pre><code>package com.udangoreng.divanandafirstapplication;</code></pre>
Diatas digunakan untuk mendeklarasikan suatu package
<pre><code>import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;</code></pre>
Diatas digunakan untuk mengimport class yang dibutuhkan seperti AppCompatActivity dan Bundle
<pre><code>setContentView(R.layout.activity_main);</code></pre>
Diatas digunakan untuk menghubungkan file activity_main.xml yang berada di dalam folder Layout
