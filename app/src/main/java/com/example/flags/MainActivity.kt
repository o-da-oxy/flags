package com.example.flags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeInteractive()
    }

    fun makeInteractive() {
        //получаем layout со всеми флагами
        val flags = findViewById<ViewGroup>(R.id.flags)
        //сделать для каждого флага обработчик нажатия
        for (i in 0 until flags.childCount) {
            val v = flags.getChildAt(i)
            v.setOnClickListener() {
                flags.removeView(it)
                it.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                setContentView(it)
            }
        }
    }

    override fun onBackPressed() {
        setContentView(R.layout.activity_main)
        makeInteractive()
    }
}