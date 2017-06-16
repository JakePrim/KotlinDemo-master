package com.links.demo.db


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/16 0016
 * 描    述：数据库表
 * 修订历史：
 * ================================================
 */

/**
 * 城市表
 */
object CityForecastTable {
    val NAME = "CityForecast"
    val ID = "_id"
    val CITY = "_city"
    val COUNTRY = "_country"
}

/**
 * 天气表
 */
object DayForecastTable {
    val NAME = "DayForecastTable"
    val ID = "_id"
    val date = "_date"
    val DECRIPTION = "_decription"
    val HIGH = "_high"
    val LOW = "_low"
    val ICON = "_icon"
    val CITY_ID = "_city_id"
}