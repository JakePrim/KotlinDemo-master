package com.links.demo.network

import com.links.demo.domain.Command
import com.links.demo.domain.ForecastDataMapper
import com.links.demo.domain.ForecastList

/**
 * Created by 17604 on 2017/6/10.
 * 得到的处理完数据的最终结果类
 */
class RequestForecastCommand(val cityCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastResult = ForecastRequest(cityCode)
        return ForecastDataMapper().convertFromDataModel(forecastResult.execute())
    }

}