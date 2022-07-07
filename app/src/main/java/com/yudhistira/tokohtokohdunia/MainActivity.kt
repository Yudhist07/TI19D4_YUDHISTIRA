package com.yudhistira.tokohtokohdunia

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.yudhistira.tokohtokohdunia.databinding.ActivityMainBinding
import com.yudhistira.tokohtokohdunia.model.Tokoh
import com.yudhistira.tokohtokohdunia.tokohtokohdunia.AdapterTokohDunia

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listTokoh = ArrayList<Tokoh>()
        listTokoh.add(Tokoh("Abbas bin Farnas",R.drawable.farnas,"780","Khwarezmia","850","Risalahnya tentang aljabar dan angka India"))
        listTokoh.add(Tokoh("Ibnu Sina",R.drawable.sina,"980-1037","Afshona Peshkunskiy Bukhara","Juni 1037 – 980","Kitab Penyembuhan Qanun Kedokteran"))
        listTokoh.add(Tokoh("Abu al-Qasim al-Zahrawi",R.drawable.zahrawi,"936-1013","Madinatuz Zahra","1013 M","Al-Tasrif"))
        listTokoh.add(Tokoh("Abbas bin Firnas",R.drawable.firnas,"810–887","Izn-Rand Onda (Ronda), Al-Andalus","Unknown","Al-Miqatah,Maket kubah langit dan Kapal terbang"))
        listTokoh.add(Tokoh("Ibnu Khaldun",R.drawable.khaldun,"27-Mei-1332","Tunisia","17 Maret 1406","Book of Lessons"))
        listTokoh.add(Tokoh("Ibnu al-Haitsam",R.drawable.haitsam,"Bashrah, 965 - Qahirah 1039","Bashrah,Buwaihiyah","1040 M","Book of Optics, Doubts Concerning Ptolemy"))
        listTokoh.add(Tokoh("Al-Jazari",R.drawable.jazari,"1136–1206","Turki","Unknown","Buku Pengetahuan Ilmu Mekanik"))
        listTokoh.add(Tokoh("Ibnu Batutah",R.drawable.batutah,"24-Februari-1304","Tanjah","1368","Ar-Rihlah"))
        listTokoh.add(Tokoh("Mimar Sinan",R.drawable.sinan,"c. 1489/1490","Ağırnas, Kayseri, Central Anatolia","17 Juli 1588","Masjid Süleymaniye,Masjid Selimiye,Jembatan Mehmed Paša Sokolović"))
        listTokoh.add(Tokoh("Cheng Ho",R.drawable.cheng,"1371","Kemnyan, Kunming, Yunnan, China","1433 – 1371","Pelaut Pembawa Pesan Kedamaian"))

        binding.List.adapter = AdapterTokohDunia(this,listTokoh,object : AdapterTokohDunia.OnClickListener {
            override fun detailData(item: Tokoh?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_tokoh)

                    val image = this.findViewById<ImageView>(R.id.image_tokoh)
                    val name = this.findViewById<TextView>(R.id.txtnameTokoh)

                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tanggallahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val wafat = this.findViewById<TextView>(R.id.txtWafat)
                    val dikenal = this.findViewById<TextView>(R.id.txtDikenal)
                    val btn = this.findViewById<Button>(R.id.btnclose)

                    image.setImageResource(item?.foto ?:0)
                    name.text = "${item?.name}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tanggallahir.text = "${item?.tgllahir}"
                    wafat.text = "${item?.wafat}"
                    dikenal.text = "${item?.dikenal}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode : Int) {
        when (selectedMode) {
            R.id.myprofile -> {
                val intent = Intent(this,Profile::class.java)
                startActivity(intent)
            }
        }
    }
}