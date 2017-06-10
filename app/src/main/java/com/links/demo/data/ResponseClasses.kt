package com.links.demo.data

/**
 * Created by 17604 on 2017/6/10.
 * 返回的json对象文件类
 */
data class ForecastResult(val cod: String, val city: City, val list: List<Forecast>)

data class City(val id: Long, val name: String, val country: String, val coord: Coordinates)
data class Coordinates(val lat: Float, val lon: Float)
data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<Weather>,
                    val speed: Float, val deg: Int, val clouds: Int,
                    val rain: Float)

data class Temperature(val day: Float, val min: Float, val max: Float,
                       val night: Float, val eve: Float, val morn: Float)

data class Weather(val id: Long, val main: String, val description: String,
                   val icon: String)