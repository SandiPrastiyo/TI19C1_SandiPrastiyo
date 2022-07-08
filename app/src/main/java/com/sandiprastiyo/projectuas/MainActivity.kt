package com.sandiprastiyo.projectuas

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
import com.sandiprastiyo.projectuas.adapter.AdapterTokohPahlawan
import com.sandiprastiyo.projectuas.databinding.ActivityMainBinding
import com.sandiprastiyo.projectuas.model.Tokoh

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getData = intent.getParcelableExtra<ModelLogin>( "data")
        binding.textView.text = getData?.username.toString()
        binding.textView.text = getData?.password.toString()



        val listTokoh = ArrayList<Tokoh>()
        listTokoh.add(Tokoh("Ir. Soekarno",R.drawable.sukarno,"Islam", "Surabaya, Jawa Timur", "6 Juni 1901"))
        listTokoh.add(Tokoh("Drs. Mohammmad Hatta",R.drawable.hatta,"Islam", "Bukit Tinggi", "2 Agustus 1902"))
        listTokoh.add(Tokoh("Tuanku Imam Bonjol",R.drawable.bonjol,"Islam", "Minangkabau", "1 Januari 1772"))
        listTokoh.add(Tokoh("Sultan Hasanuddin",R.drawable.hasanuddin,"Islam", "Makasar", "12 Januari 1631"))
        listTokoh.add(Tokoh("R.A Kartini",R.drawable.kartini,"Islam", "Jepara", "21 April 1879"))
        listTokoh.add(Tokoh("Kapiten Patimura",R.drawable.patimura,"Islam", "Maluku", "8 Juni 1783"))
        listTokoh.add(Tokoh("Dewi Sartika",R.drawable.sartika,"Islam", "Bandung", "4 Desember 1884"))
        listTokoh.add(Tokoh("Jendral Sudirman",R.drawable.sudirman,"Islam", "Purbalingga", "24 Januari 1916"))
        listTokoh.add(Tokoh("Bung Tomo",R.drawable.tomo,"Islam", "Surabaya", "3 Oktober 1920"))
        listTokoh.add(Tokoh("Muhammad Yamin",R.drawable.yamin,"Islam", "Talawi", "24 Agustus 1903"))

        binding.list.adapter = AdapterTokohPahlawan(this,listTokoh,object : AdapterTokohPahlawan.OnClickListener {
            override fun detailData(item: Tokoh?) {
               Dialog(this@MainActivity).apply {
                   requestWindowFeature(Window.FEATURE_NO_TITLE)
                   setCancelable(true)
                   setContentView(R.layout.detail_data_tokoh)

                   val image = this.findViewById<ImageView>(R.id.image_tokoh)
                   val  nama = this.findViewById<TextView>(R.id.txtNamaTokoh)
                   val  agama = this.findViewById<TextView>(R.id.txtAgama)
                   val  tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                   val  tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                   val btn = this.findViewById<Button>(R.id.btnClose)

                   image.setImageResource(item?.foto ?:0)
                   nama.text = "${item?.nama}"

                   agama.text = "${item?.agama}"
                   tempatlahir.text = "${item?.tempatlahir}"
                   tgllahir.text = "${item?.tgllahir}"

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