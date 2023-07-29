# Hello Toast dan Count

Project ini adalah tugas pada hari Rabu, 26 Juli 2023. Project ini berfokus untuk membuat dua buah fungsi, Toast dan countUp yang digunakan untuk menampilkan suatu toast dan menambah nilai dengan menggunakan tombol.

## Penjelasan

<pre><code>private int mCount = 0;
private TextView mShowCount;
</code></pre>
Berfungsi untuk mendeklarasikan variable integer mCount dan TextView mShowCount
<pre><code>mShowCount = (TextView) findViewById(R.id.show_count);</code></pre>
Memanggil TextView dengan id show_count
<pre><code>public void showToast(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_message, Toast.LENGTH_LONG);
        toast.show();
    }
</code></pre>
Merupakan Fungsi untuk menampilkan Toast. Syntax yang digunakan adalah Toast.makeText(context, message, duration).
getApplicationContext berfungsi untuk mengambil infromasi dari aplikasi saat ini. Toast dimasukkan ke dalam sebuah variabel toast dan kemudian dipanggil dengan toast.show();
<pre><code>public void countUp(View view) {
        mCount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }
</code></pre>
Merupakan fungsi untuk menambah angka dan menampilkannya. Variable int mCount akan ditambah dan kemudian menampilkannya pada mShowCount yang telah di deklarasikan sebelumnya.
<pre><code>android:onClick=function</code></pre>
Kode ini akan menjalankan sebuah fungsi tertentu yang disebutkan apabila suatu tombol ditekan.

Sama seperti string yang dapat ditambahkan pada string.xml dengan ALT+Enter, fungsi juga dapat ditambahkan dengan menggunakan shortcut yang sama, yang mana akan langsung membuat suatu fungsi ke dalam MainActivity.java.
