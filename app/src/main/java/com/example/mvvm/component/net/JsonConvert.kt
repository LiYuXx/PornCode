package com.example.mvvm.component.net

import com.alibaba.fastjson.JSONObject
import com.drake.net.convert.DefaultConvert
import java.lang.reflect.Type

class JsonConvert : DefaultConvert() {

    override fun <S> String.parseBody(succeed: Type): S? {
        return JSONObject.parseObject(this, succeed)
    }
}