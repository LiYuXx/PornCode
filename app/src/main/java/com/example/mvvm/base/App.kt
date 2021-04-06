package com.example.mvvm.base

import android.app.Application
import com.drake.brv.utils.BRV
import com.drake.logcat.LogCat
import com.drake.net.cacheEnabled
import com.drake.net.initNet
import com.drake.net.logEnabled
import com.example.mvvm.BR
import com.example.mvvm.component.net.JsonConvert
import com.example.mvvm.const.AppConfig
import com.tencent.mmkv.MMKV

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initEngine()
        initNet("127.0.0.1") {
            converter(JsonConvert()) // 转换器
            cacheEnabled() // 开启缓存
            logEnabled = AppConfig.DEBUG // 网络日志, 建议安装OkHttpProfile插件查看日志
        }
        MMKV.initialize(this)
        BRV.modelId = BR.m
        LogCat.enabled = AppConfig.DEBUG
    }
}