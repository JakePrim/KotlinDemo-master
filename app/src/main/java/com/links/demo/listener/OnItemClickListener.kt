package com.links.demo.listener

import com.links.demo.domain.Forecast

/**
 * Created by 17604 on 2017/6/11.
 * item 的监听
 */
public interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}