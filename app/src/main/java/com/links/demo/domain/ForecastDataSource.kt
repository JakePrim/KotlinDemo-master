package com.links.demo.domain

import java.util.logging.LogManager


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/29 0029
 * 描    述：数据库查询、保存 处理的接口
 * 修订历史：
 * ================================================
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(cityCode: Long, date: Long): ForecastList?
    fun requesyDayForecastByZipCode(id: Long): Forecast?
}