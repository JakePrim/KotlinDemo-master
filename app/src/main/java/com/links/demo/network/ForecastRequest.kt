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

    fun execute(): ForecastResult {
        println(COMPLETE_URL + citycode)
        val forecastStr = URL(COMPLETE_URL + citycode).readText()
        return Gson().fromJson(forecastStr, ForecastResult::class.java)
    }

}