package com.example.katalognovel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var string: String
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.button -> {
                string = editText.text.toString()
                textView.text = "Selamat Datang $string"
                val moveWithDataIntent = Intent(this@MainActivity, KatalogActivity::class.java)
                moveWithDataIntent.putExtra(KatalogActivity.EXTRA_NAME, string)
                startActivity(moveWithDataIntent)
            }

        }
    }
}

private fun Parcelable.putExtra(Nama: String, editText: EditText) {

}
