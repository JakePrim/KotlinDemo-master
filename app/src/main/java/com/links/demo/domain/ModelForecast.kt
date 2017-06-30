package com.links.demo.domain

/**
 * Created by 17604 on 2017/6/10.
 * 这个类我们需要的数据类，我们可以用Link{ForecastDataMapper} 将网络返回的数据进行转换
 */
data class ForecastList(val id: Long, val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {
    operator fun get(position: Int): Forecast = dailyForecast[position] //获取它的每一项
    fun size() = dailyForecast.size
}

data class Forecast(val id: Long,val date: Long, val description: String, val high: Int,
                    val low: Int, val iconUrl: String)