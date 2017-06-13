package com.links.demo.domain

/**
 * Created by 17604 on 2017/6/10.
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {
    operator fun get(position: Int): Forecast = dailyForecast[position] //获取它的每一项
    fun size() = dailyForecast.size
}

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int, val iconUrl: String)