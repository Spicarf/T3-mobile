package com.tugas

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val rgKelamin = findViewById<RadioGroup>(R.id.rgKelamin)
        val rbLaki = findViewById<RadioButton>(R.id.rbLaki)

        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)

        val btnTampil = findViewById<Button>(R.id.btnTampil)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampil.setOnClickListener {
            val nama = etNama.text.toString()

            // VALIDASI
            if (nama.isEmpty()) {
                etNama.error = "Nama tidak boleh kosong"
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (rgKelamin.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val kelamin = if (rbLaki.isChecked) "Laki-laki" else "Perempuan"

            val hobiList = mutableListOf<String>()
            if (cbMembaca.isChecked) hobiList.add("Membaca")
            if (cbCoding.isChecked) hobiList.add("Coding")
            if (cbOlahraga.isChecked) hobiList.add("Olahraga")

            val hasil = """
                Nama     : $nama
                Kelamin  : $kelamin
                Hobi     : ${if (hobiList.isNotEmpty()) hobiList.joinToString(", ") else "Tidak ada"}
            """.trimIndent()

            tvHasil.text = hasil
        }
    }
}