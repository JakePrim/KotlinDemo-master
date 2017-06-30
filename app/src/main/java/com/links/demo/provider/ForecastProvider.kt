package com.links.demo.provider

import com.links.demo.db.ForecastDb
import com.links.demo.domain.ForecastDataSource
import com.links.demo.domain.ForecastList
import com.links.demo.listener.firstResult
import com.links.demo.server.ForecastServer
import java.text.DateFormat
import java.util.*

/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/29 0029
 * 描    述：forecast provider接收一个数据源列表，通过构造函数传入（比如用于测试），
 * 但是我设置了source的默认值为被定义在companion object中的SOURCESList。
 * 我将使用数据库的数据源和服务端数据源。顺序是很重要的，因为它会根据顺序去遍历这个sources，
 * 然后一旦获取到有效的返回值就会停止查询。逻辑顺序是先在本地查询（本地数据库中），然后再通过API查询。
 * 修订历史：
 * ================================================
 */
class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = sources.firstResult { requestSource(it, days, zipCode) }

    fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, convertDate(todayTimeSpan()))
        return if (res != null && res.size() >= days) res else null
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}