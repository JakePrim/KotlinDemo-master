package com.links.demo.network

/**
 * Created by 17604 on 2017/6/11.
 */
 val APPID = "15646a06818f61f7b8d7823ca833e1ce"
 val BASE_URL = "http://api.openweathermap.org/data/2.5/" +
        "forecast/daily?mode=json&units=metric&cnt=7"
 val COMPLETE_URL = "$BASE_URL&appid=$APPID&q="