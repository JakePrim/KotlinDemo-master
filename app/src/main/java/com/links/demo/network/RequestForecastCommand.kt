package com.links.demo.network

import com.links.demo.domain.Command
import com.links.demo.domain.ForecastDataMapper
import com.links.demo.domain.ForecastList
import com.links.demo.provider.ForecastProvider

/**
 * Created by 17604 on 2017/6/10.
 * 得到的处理完数据的最终结果类
 */
class RequestForecastCommand(val cityCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {

    override fun execute(): ForecastList = forecastProvider.requestByZipCode(cityCode, DAYS)

    companion object {
        val DAYS = 7
    }

//    override fun execute(): ForecastList {
//        val forecastResult = ForecastRequest(cityCode)
//        return ForecastDataMapper().convertFromDataModel(forecastResult.execute())
//    }

}