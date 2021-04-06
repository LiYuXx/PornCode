package com.example.mvvm.const

import com.drake.serialize.serialize.serial
import com.example.mvvm.BuildConfig

/**
 * 应用配置
 */
object AppConfig {
    const val DEBUG = BuildConfig.BUILD_TYPE == "debug" // 是否为开发环境, 可能存在正式环境下开启调试模式
    var isFirstLaunch: Boolean by serial(default = true) // 是否是第一次启动App
}