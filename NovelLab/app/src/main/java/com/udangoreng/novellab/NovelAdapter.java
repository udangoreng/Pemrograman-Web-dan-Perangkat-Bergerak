package com.udangoreng.novellab;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.CollationElementIterator;
import java.util.Arrays;
import java.util.List;

public class NovelAdapter extends RecyclerView.Adapter<NovelAdapter.NovelViewHolder>{
    public class NovelViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout containerView;
        private TextView titleView, writerView, yearView;
        private ImageView imageView;
        public NovelViewHolder(@NonNull View thisView) {
            super(thisView);
            containerView = thisView.findViewById(R.id.novel_item);
            titleView = thisView.findViewById(R.id.title_textView);
            writerView = thisView.findViewById(R.id.writer_textView);
            yearView = thisView.findViewById(R.id.year_textView);
            imageView = thisView.findViewById(R.id.imageView);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Novel current = (Novel) containerView.getTag();
                    Intent intent = new Intent(view.getContext(), SecondActivity.class);
                    intent.putExtra("title", current.getTitle());
                    intent.putExtra("writer", current.getWriter());
                    intent.putExtra("year", current.getYear());
                    intent.putExtra("image", current.getCover());
                    intent.putExtra("desc", current.getSynopsis());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    private List<Novel> novels = Arrays.asList(
            new Novel(R.drawable.hp1, "Harry Potter and the Philosoper Stone", "JK Rowling", "Novel ini menceritakan seorang penyihir muda bernama Harry Potter yang menemukan warisan magisnya pada hari ulang tahunnya yang kesebelas, ketika ia menerima surat penerimaan ke Sekolah Sihir Hogwarts. Harry Potter ternyata sangat terkenal di dunia sihir sehingga menyebabkan ada pihak yang mengelu-elukannya namun ada pula yang membencinya.\n" +
                    "\n" +
                    "Hal ini menyebabkan kehidupan sekolah Harry di Hoghwart menjadi penuh warna, terlebih sejak awal telah terjadi persaingan antara keempat asrama, Gryffindor, Hupplepuff, Ravenclaw, dan Slytherin. Bau permusuhan jelas sangat terasa dari kubu Slyterin yang selama ini memang terkenal menghasilkan para penyihir yang kemudian membelot ke Lord Voldermort menuju kegelapan.\n" +
                    "\n" +
                    "Keberadaan teman-teman baru di Asrama Gryffindor merupakan berkah bagi Harry karena selama ini dia tidak punya teman di sekolah lamanya. Ron Weasley telah menjadi temannya sejak mereka saling menyapa di Kereta Api yang membawa semua murid baru dari Stasiun King Cross ke Hogwarts. Ron yang terbilang ceroboh, nakal, dan cukup rakus itu bukan satu-satunya teman dekat Harry. Hermione Granger yang selalu ingin menjadi nomor satu dalam setiap pelajaran tanpa sengaja bergabung dalam pertemanan Ron dan Harry dalam sebuah peristiwa yang mengikat ketiganya, dimana peristiwa itu sempat membuat gadis yang taat peraturan itu harus mengalami kenakalan pertamanya.\n" +
                    "\n" +
                    "Di antara semua mata pelajaran di Hogwarts, Harry paling menguasai pelajaran terbang dimana sejak hari pertama dia menaiki sapunya dia langsung menarik perhatian dan dimasukkan ke dalam tim Quidditch, sebuah permainan olah raga favorit seperti layaknya sepak bola di dunia sihir. Pelajaran yang paling Harry benci tentu saja adalah pelajaran ramuan yang memaksanya harus menghadapi guru yang sepertinya sangat membencinya dan menganak emaskan asrama Slytherin.\n" +
                    "\n" +
                    "Para guru di Hogwarts itulah yang kemudian memiliki andil besar dalam petualangan Harry Potter menjelajahi dunia sihir. Ketika ada seorang guru yang sangat dicurigainya mempunyai motif jahat, Harry terus saja berusaha mencari kebenaran seiring terus bermunculannya kasus mengerikan di sekitar Hogwarts, pertanda awal kembalinya Lord Voldermort.\n" +
                    "\n" +
                    "Hmm… gimana yah jadinya jika Lord Voldermort kembali!? Apa yang akan terjadi di dalam dunia sihir!?", 1997),
            new Novel(R.drawable.hp3, "Harry Potter and The Prisoner of Azkaban", "JK Rowling","Harry Potter and The Prisoner of Azkaban, novel ketiga seri Harry Potter yang ditulis oleh J.K. Rowling. Novel ini mengisahkan tentang Harry yang berusaha menghindari Sirius Black, penyihir jahat yang baru kabur dari penjara Azkaban.\n" +
                    "\n" +
                    "Sirius Black yang kabur dari penjara Azkaban ternyata mengincar Harry dan membuat Kementrian Sihir mengirimkan Dementor dari Azkaban untuk berpatroli di Hogwarts. Saat tahun ketiga Harry bersekolah, ia mendapatkan ancaman maut dan akhirnya ia mengetahui fakta baru tentang masa lalunya. Ia juga bertemu dan bertatap muka dengan pelayan Pangeran Kegelapan yang paling setia.\n" +
                    "\n" +
                    "Sinopsis Buku\n" +
                    "\n" +
                    "Ketika Bus Ksatria membelah kegelapan malam dan berhenti mendadak di hadapan Harry Potter, maka dimulailah tahun ajaran berikutnya di Hogwarts yang jauh dari biasa-biasa saja.\n" +
                    "\n" +
                    "Sirius Black, pembunuh massal dan pengikut Lord Voldemort, kabur dari penjara Azkaban— dan konon dia memburu Harry.\n" +
                    "\n" +
                    "Pada pelajaran Ramalan pertama, Profesor Trelawney melihat terawangan kematian dalam ampas teh anak itu...\n" +
                    "\n" +
                    "Namun, tak ada yang lebih menakutkan daripada para Dementor, sosok-sosok pengisap jiwa, yang gentayangan di sekeliling sekolah.", 1999),
            new Novel(R.drawable.hp5, "Harry Potter and The Order of Phoenix", "JK Rowling", "Tidak banyak penyihir yang percaya (atau mau percaya) bahwa Voldermort telah kembali, termasuk Kementerian Sihir. Harry dan Dumbledore dianggap menyebar kabar bohong dan dianggap terganggu jiwanya. Meskipun demikian, masih banyak orang yang percaya pada Dumbledore, dan merek inilah yang tergabung dalam Orde Phoenix. Namun, karena situasi belum memungkinkan, mereka bergerak secara diam-diam untuk menghindari kecurigaan dari Kementerian. Mereka menggunakan kediaman Sirius, Grimmauld Place nomor 12 sebagai Markas Besar sehingga Sirius tidak lagi dalam pelarian, tapi tetap bersembunyi karena pihak kementrian masih mencarinya.\n" +
                    "\n" +
                    "Sementara itu, Harry yang diawasi siang-malam (tanpa sepengetahuannya) oleh anggota Orde, semakin sering mengalami sakit pada bekas lukanya. Sekembalinya ke Hogwarts, Harry menghadapi persidangan karena mengeluarkan sihir di dunia Muggle dan emosinya sering tak terkendali. Pada suatu malam ia dikejutkan dengan hadirnya dementor di Privet Drive yang hendak menyerang dirinya dan Dudley. Untunglah ia berhasil menghasilkan patronus untuk melawan mereka. Namun, akibat dari hal ini, dia nyaris diusir oleh pamannya karena dikira menyerang Dudley menghadapi persidangan di Kementerian Sihir dan terancam dikeluarkan dari Hogwarts.\n" +
                    "\n" +
                    "Harry tidak sendirian: di Grimmauld Place berkumpul orde rahasia untuk melawan kekuatan gelap. Harry harus mengizinkan Profesor Snape mengajarinya cara melindungi diri dari rentetan serangan brutal Voldemort dari benaknya. Namun, serangan-serangan itu makin ganas dan Harry kehabisan waktu. Apakah Harry berhasil melakukan perlindungan diri? Apa yang akan terjadi dengan anggota Orde?", 2003),

            new Novel(R.drawable.pj1, "Percy Jackson and The Lightning Thief", "Rick Riordan", "Aku Percy Jackson. Aku sudah dikeluarkan dari sekolah berkali-kali, sebagian karena aku penyandang disleksia dan GPPH (Gangguan Pemusatan Perhatian dan Hiperaktif), sebagian lagi karena masalah sepertinya suka sekali mengejarku ke mana pun aku pergi. Yang lebih buruk lagi, aku ternyata demigod. Kalau menurutmu memiliki orang tua dewata itu menyenangkan, kau salah. Sebagai demigod, kami harus menjalani misi dan menjadi pahlawan, yang berarti kami selalu diburu monster, dibenci oleh kebanyakan dewa, dan seringnya mati muda.\n" +
                    "\n" +
                    "Siapa ayahku? Yang jelas bukan Zeus karena dia menuduhku mencuri petirnya dan agak terlalu berambisi ingin mengenyahkan dari dunia. Dan, karena nasibku memang luar biasa buruk, aku cuma punya waktu sepuluh hari untuk membuktikan bahwa aku tidak bersalah sebelum para dewa berperang karena amukan Zeus. Dengan ramalan yang berkata, Dan, pada akhirnya, kau akan gagal menyelamatkan apa yang menurutmu paling signifikan.", 2005),
            new Novel(R.drawable.orv, "Omniscient Reader Viewpoint", "Sing Shong","‘Omniscient Reader’ berfokus pada Kim Dokja, seorang pekerja kantoran berusia 28 tahun yang kesepian di Korea yang membaca novel web sebagai hobi. Dalam perjalanan pulang dengan kereta bawah tanah, web novel yang dibaca Dokja selama satu dekade terakhir akhirnya berakhir. Web novel dalam cerita, “Three Ways to Survive the Apocalypse” (TWSA), berakhir dengan lebih dari 3.000 bab, dengan Dokja sebagai satu-satunya pembaca web novel tersebut—yang juga berarti hanya dia yang tahu bagaimana ceritanya akan berakhir. Setelah menyelesaikan ceritanya, penulis, tls123, menghubungi Dokja dan mengatakan bahwa TWSA akan menjadi konten berbayar pada jam 7 malam. Kebetulan kereta bawah tanah yang ditumpangi Dokja diserang pada pukul 7 malam. Ketika seorang dokkaebi, atau goblin Korea, memberikan skenario pencarian dari TWSA, Dokja menyadari bahwa novel tercinta yang dia baca selama dekade terakhir menjadi kenyataan..", 2018),
            new Novel(R.drawable.sh, "Sherlock Holmes : A Study In Scarlet", "Arthur Conan Doyle","Inilah petualangan pertama Sherlock Holmes dan Dokter Watson. Berawal dari sebuah apartemen kecil di Baker Street, mereka kedatangan seorang klien untuk mengungkap kasus pembunuhan misterius. Telah ditemukan sosok mayat yang meninggal tak wajar dan tanpa ada barang bukti pembunuhan. Sherlock Holmes dengan sigap mencoba mengurai semuanya. Mulai dari melacak jejak pelaku, melacak bukti-bukti yang ada di sekitar kejadian, juga melacak motif pembunuhan. Bagaimana cara sang detektif ulung ini melakukan pekerjaannya? Juga apa reaksi Dokter Watson saat mengikuti Sherlock di kasus pertama ini?", 1887),
            new Novel(R.drawable.ddh, "Dikta dan Hukum", "Dhian Farah", "Novel Dikta & Hukum menceritakan tentang seorang tokoh bernama Dikta yang merupakan mahasiswa hukum tingkat akhir di sebuah universitas ternama dan menjadi salah satu mahasiswa terpintar.\n" +
                    "\n" +
                    "Dikta merupakan tokoh idaman semua wanita karena penggambarannya yang sempurna. Ia kaya, rajin, pintar, baik, penyayang dan tentunya berparas tampan. Di sisi lain terdapat tokoh bernama Nadhira yang merupakan anak SMA kelas 12 dengan karakter berbanding terbalik dengan Dikta, pemalas dan mageran. Nadhira dikenal sebagai orang yang banyak mau, keras kepala dan suka mengeluh. Berbeda dengan image Dikta yang dikenal sebagai sosok yang serius dan disiplin.\n" +
                    "\n" +
                    "Siapa sangka jika Dikta dijodohkan dengan gadis SMA bernama Nadhira itu dengan sifat dan watak mereka yang amat sangat berbanding terbalik bagai langit dan bumi. Demi menjaga perasaan kedua orang tuanya, mereka terpaksa harus terjebak dalam hubungan yang semakin rumit ini.\n" +
                    "\n" +
                    "Seiring berjalannya waktu, Nadhira mulai menaruh rasa suka pada Dikta dan benar saja kali ini Nadhira benar-benar jatuh cinta pada sosok yang sejak dulu hanya dianggapnya sebagai kakak. Meskipun begitu kisah percintaan mereka yang rumit akan dibahas dan rahasia-rahasia Dikta yang selama ini dipendam akan mulai terungkap.\n" +
                    "\n" +
                    "“Ini cerita sederhana yang efeknya luar biasa. Engga cuma bikin halu, tapi bikin pintar juga.”\n" +
                    "\n" +
                    "UUDN = Undang-undang Dikta Nadhira\n" +
                    "•Pasal satu, Dasar hukum perjodohan yang mengikat kedua belah pihak (Nadhira dan Dikta).\n" +
                    "•Pasal dua, memuat tentang bagaimana Keduanya tanpa sadar saling menghindar agar tak jatuh hati.\n" +
                    "•Pasal tiga, Menjelaskan kedua belah pihak terhukum dengan jatuh hati yang tak bisa mereka hindari lagi.\n" +
                    "•Pasal empat, ketentuan umum keduanya sebagai kekasih yang saling mengasihi.\n" +
                    "•Pasal lima, Kewenangan absolut Semesta menentukan akhir dari cerita yang mereka yakini akan abadi.", 2021),
            new Novel(R.drawable.lb,"Laut Becerita"," Leila S. Chudori","Buku ini terdiri atas dua bagian. Bagian pertama mengambil sudut pandang seorang mahasiswa aktivis bernama Laut, menceritakan bagaimana Laut dan kawan-kawannya menyusun rencana, berpindah-pindah dalam pelarian, hingga tertangkap oleh pasukan rahasia. Sedangkan bagian kedua dikisahkan oleh Asmara, adik Laut. Bagian kedua mewakili perasaan keluarga korban penghilangan paksa, bagaimana pencarian mereka terhadap kerabat mereka yang tak pernah kembali.\n" +
                    "Buku ini ditulis sebagai bentuk tribute bagi para aktivis yang diculik, yang kembali, dan yang tak kembali dan keluarga yang terus menerus sampai sekarang mencari-cari jawaban.\n" +
                    "\n" +
                    "Novel ini merupakan perwujudan dalam bentuk fiksi bahwa kita sebagai bangsa Indonesia tidak boleh melupakan sejarah yang telah membentuk sekaligus menjadi tumpuan bangsa Ini. Novel ini juga mengajak pembaca menguak misteri-misteri bangsa ini yang mana tidak diajarkan di sekolah. Walaupun novel ini adalah fiksi, laut bercerita menunjukkan kepada pembaca bahwa negeri ini pernah memasuki masa pemerintahan yang kelam.", 2017 ),
            new Novel(R.drawable.snowy, "Befuddles", "Destharan", "'Pilih Aku atau dia?'\nPertanyaan itu terdengar begitu tenang dan dingin disertai tatapan tanpa emosi dari Snowy, membuat Reifan sedikit tertegun. Dipandanginya wajah sang kekasih yang sudah 3 tahun ini merajut asmara dengannya dengan lekat, meneliti iris cokelatnya yang biasanya bening berbinar kini tampak datar. 'Snowy'\n\n'Pilih aku atau dia?' Snowy masih mempertahankan pertanyaannya. Namun kali ini, tatapan gadis itu jatuh pada seseorang di samping Reifan, Liona sahabat mereka sejak kecil.\n\n'Princess, kamu tahu kamu bukan pilihan,' ucap Reifan tegas. Cowok bersurai hitam dengan poni sedikit turun ke dahi itu semakin lekat menatap gadis di depannya, seolah ingin dipahami bahwa apa yang ia katakan adalah kebenaran.\n\nHarusnya kalimat itu menjadi penenang bagi Snowy karena kekasihnya secara tidak langsung menegaskan bahwa Snowy adalah satu-satunya perempuan untuk Reifan. Namun yang terjadi tidak seperti itu, kini di antara mereka ada Liona,\n\nSahabat mereka sejak kecil yang sejak 2 bulan lalu tinggal di rumah Snowy karena sebuah kejadian tragis. Sialnya kejadian itu terjadi karena Snowy, sehingga keluarganya bertanggung jawab penuh atas Liona saat ini.\n\nTidak ada yang menyangka hidup bisa tiba-tiba berubah secara drastis. Kehilangan kepercayaan dan dijauhi oleh orang tersayang dalam waktu yang bersamaan jelas sangat menyiksa.\n\nItulah nasib yang sedang Snowy hadapi. Kehidupannya yang serba menyenangkan, penuh kasih sayang, dan menjadi pusat perhatian lenyap begitu saja karena insiden kecelakaan yang tidak ia sengaja dan memakan korban.\n\nBeruntung, orang tua Snowy masih berpihak kepadanya. Namun, tidak dengan saudara kembarnya, kekasihnya, dan juga sahabat-sahabatnya. Mereka menatap Snowy seperti pembunuh dan selalu menyalahkannya atas kesedihan yang dirasakan Liona, anak sopir keluarga Hengkara.\n\nYa, korbannya adalah sopirnya sendiri yang kini mengalami koma.\n\nTidak ada satu orang pun yang bisa Snowy percaya untuk memberikan kebahagiaan bahkan orang tuanya sendiri, tetapi semesta mengirim hadiah istimewa di tengah keterpurukannya.\n\nAghasatya Mahatama hadir membawa segudang kebahagiaan untuknya, menjadi penghangat kala badai dalam hidupnya menerjang.", 2023),
            new Novel(R.drawable.oouil, "One Of Us Is Lying", "Karen M. McMagnus", "Senin sore, lima murid memasuki ruang detensi.\n" +
                    "\n" +
                    "Bronwyn, si genius, nilai akademis sempurna dan tidak pernah melanggar peraturan.\n" +
                    "Addy, si cewek populer, gambaran sempurna pemenang kontes kecantikan.\n" +
                    "Nate, si bandel, dalam masa percobaan karena transaksi narkoba.\n" +
                    "Cooper, si atlet, pelempar bola andalan tim bisbol dan pangeran di hati semua orang.\n" +
                    "Dan Simon, si orang buangan, pencipta aplikasi gosip terdepan mengenai kehidupan Bayview High.\n" +
                    "\n" +
                    "Namun sayangnya sebelum detensi berakhir, Simon tewas.\n" +
                    "\n" +
                    "Menurut para penyidik, kematiannya disengaja. Apalagi kemudian ditemukan draft artikel gosip terbaru untuk ditayangkan pada Selasa, sehari setelah kematian Simon. Gosip heboh tentang empat orang yang berada dalam ruangan detensi bersamanya. Mereka berempat dicurigai, dan semuanya punya rahasia terpendam. Salah satu di antara mereka pasti ada yang berbohong.\n" +
                    "\n" +
                    "Dituduh sebagai pembunuh teman sendiri, dicurigai dan diburu media setiap hari, jelas tidak tenang rasanya pasti hidup seperti itu. Hal ini lah yang dirasakan oleh Nate, Abby, Bronwyn, dan Cooper karena kematian teman mereka, Simon. Berawal dari ketika mereka dan temannya Simon dipanggil ke ruangan Mr. Avery karena ketahuan membawa ponsel di tas mereka. Mereka semua menyangkal atas tuduhan tersebut. Tapi tetap saja Mr. Avery mengumpulkan mereka di ruang detensi. Sampai kemudian terjadilah tragedi tersebut. Lalu siapakah pembunuh yang sebenarnya? Apakah Simon benar-benar dibunuh atau kematiannya hanyalah kecelakaan?", 2017)
            );

    @NonNull
    @Override
    public NovelAdapter.NovelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.novel_items, parent, false);
        return new NovelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NovelAdapter.NovelViewHolder holder, int position) {
        Novel current = novels.get(position);
        holder.titleView.setText(current.getTitle());
        holder.writerView.setText(current.getWriter());
        holder.yearView.setText(Integer.toString(current.getYear()));
        holder.imageView.setImageResource(current.getCover());
        holder.containerView.setTag(current);

    }

    @Override
    public int getItemCount() {
        return novels.size();
    }
}
