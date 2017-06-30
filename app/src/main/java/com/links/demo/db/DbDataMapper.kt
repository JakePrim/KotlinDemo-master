package com.links.demo.db

import com.links.demo.domain.Forecast
import com.links.demo.domain.ForecastList


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/29 0029
 * 描    述：这些类必须从数据映射到我们的domain类 link
 * 修订历史：
 * ================================================
 */
class DbDataMapper {

    /**
     * with 函数可以便利对象
     * 将数据库取出的数据转换为我们需要的数据link{ForecastList}
     */
    fun convertToDomain(forcase: CityForecast) = with(forcase) {
        val dayForecast = datForecast.map { converDayToDomain(it) }
        ForecastList(_id, city, country, dayForecast)
    }


    fun converDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(_id, date, description, high, low, icon)
    }

    /**
     * 将从网络上获取的数据转换为数据库存储的数据类 存储一天的天气
     */
    fun converDayFromDomain(forecast: Forecast, id: Long) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, id)
    }

    /**
     * 存储城市未来几天的天气
     */
    fun converFromDomain(forecastList: ForecastList) = with(forecastList) {
        val daily = dailyForecast.map { converDayFromDomain(it, id) }
        CityForecast(id, city, country, daily)
    }
}