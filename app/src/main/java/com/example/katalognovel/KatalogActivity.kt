package com.example.katalognovel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.katalognovel.customize.*
import com.example.katalognovel.fragment.HorrorFragment
import com.example.katalognovel.fragment.RomanceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_katalog.*

class KatalogActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            item -> val fragment: Fragment

        when (item.itemId) {
            R.id.navigation_horror -> {
                fragment = HorrorFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                    .commit();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_romance -> {

                fragment = RomanceFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                    .commit();
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_katalog)

        val tvDataReceived: TextView = findViewById(R.id.tv_data_recieved)

        val name = intent.getStringExtra(EXTRA_NAME)

        val text = spannable {
            normal(color(Color.BLACK, "Selamat Datang di Aplikasi From Home")) +
            bold(color(Color.rgb(250, 250, 250), "\n$name"))
        }
        tvDataReceived.text = text

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            navigation.selectedItemId = R.id.navigation_horror
        }
    }

}