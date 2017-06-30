package com.links.demo.server

import com.links.demo.db.ForecastDb
import com.links.demo.domain.ForecastDataMapper
import com.links.demo.domain.ForecastDataSource
import com.links.demo.domain.ForecastList
import com.links.demo.network.ForecastRequest


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/29 0029
 * 描    述：它在从服务端接收到数据之后就会使用ForecastDb去保存到数据库
 *          用这种方式，我们就可以缓存这些数据到数据库中，提供给以后的查询
 * 修订历史：
 * ================================================
 */
class ForecastServer(val dbDataMapper: ForecastDataMapper = ForecastDataMapper(), val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {
    override fun requestForecastByZipCode(cityCode: Long, date: Long): ForecastList? {
        val result = ForecastRequest(cityCode.toString()).execute()
        val forecatlist = dbDataMapper.convertFromDataModel(result, cityCode)
        forecastDb.saveForecast(forecatlist)
        return forecastDb.requestForecastByZipCode(cityCode, date)
    }

    override fun requesyDayForecastByZipCode(id: Long) = throw UnsupportedOperationException()

}