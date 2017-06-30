package com.links.demo.db

import com.links.demo.domain.ForecastDataSource
import com.links.demo.domain.ForecastList
import com.links.demo.listener.clear
import com.links.demo.listener.parseList
import com.links.demo.listener.parseOpt
import com.links.demo.listener.toVarargArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/29 0029
 * 描    述：数据库数据管理类 查询和保存
 * 修订历史：
 * ================================================
 */
class ForecastDb(val forecastDbHelper: ForecastDBHelper = ForecastDBHelper.instance, val dbDataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {

    /**
     * 保存每一天的数据
     */
    fun saveForecast(forecastList: ForecastList) = forecastDbHelper.use {
        println("开始写入数据库")
        clear(DayForecastTable.NAME)
        clear(CityForecastTable.NAME)
        with(dbDataMapper.converFromDomain(forecastList)) {
            //将返回的天气列表存入 城市和 天气列表中
            //首先插入城市表
            insert(CityForecastTable.NAME, *map.toVarargArray())
            //然后循环插入天气表
            datForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
        println("写入数据库完成")
    }

    /**
     * 根据城市 和 时间范围来查询数据库中的天气信息列表
     */
    override fun requestForecastByZipCode(cityCode: Long, date: String) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ? "
        val dailyForecat = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, cityCode.toString(), date)
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ? ", cityCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecat) }
        println("查询数据")
        city?.let { dbDataMapper.convertToDomain(it) }

    }

    /**
     *
     */
    override fun requesyDayForecastByZipCode(id: Long) = forecastDbHelper.use {
        val dayforecast = select(DayForecastTable.NAME)
                .whereSimple("${DayForecastTable.CITY_ID} = ?", id.toString())
                .parseOpt { DayForecast(HashMap(it)) }

        dayforecast?.let { dbDataMapper.converDayToDomain(it) }
    }


}




