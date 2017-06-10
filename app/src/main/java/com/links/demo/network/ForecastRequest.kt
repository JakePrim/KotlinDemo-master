package com.links.demo.network

import com.google.gson.Gson
import com.links.demo.data.ForecastResult
import java.net.URL

/**
 * Created by 17604 on 2017/6/10.
 * ForecastRequest
 *Companion objects
 *Kotlin允许我们去定义一些行为与静态对象一样的对象。
 * 尽管这些对象可以用众所周知的模式来实现，比如容易实现的单例模式。
 *我们需要一个类里面有一些静态的属性、常量或者函数，
 * 我们可以使用companion objecvt。这个对象被这个类的所有对象所共享，就像Java中的静态属性或者方法。
 *
 * 网路请求类
 */
class ForecastRequest(val citycode: String) {
    companion object {
        private val APPID = "15646a06818f61f7b8d7823ca833e1ce"
        private val BASE_URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$BASE_URL&appid=$APPID&q="
    }

    fun execute(): ForecastResult {
        val forecastStr = URL(COMPLETE_URL + citycode).readText()
        println(forecastStr)
        return Gson().fromJson(forecastStr, ForecastResult::class.java)
    }
}