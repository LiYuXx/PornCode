package com.example.mvvm.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.drake.statusbar.immersive
import com.example.mvvm.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        immersive(darkMode = true)
    }
}