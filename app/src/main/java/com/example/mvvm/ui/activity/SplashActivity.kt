package com.example.mvvm.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.drake.serialize.intent.openActivity
import com.example.mvvm.R
import com.example.mvvm.const.AppConfig

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (AppConfig.DEBUG) {
            intoHome()
        } else {
            window.decorView.postDelayed({ intoHome() }, 1500)
        }
    }

    private fun intoHome() {
        openActivity<MainActivity>()
        AppConfig.isFirstLaunch = false
    }
}