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
    val CITY = "city"
    val COUNTRY = "country"
}

/**
 * 天气表
 */
object DayForecastTable {
    val NAME = "DayForecastTables"
    val ID = "_id"
    val DATE = "date"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val ICON = "icon"
    val CITY_ID = "cityId"
}