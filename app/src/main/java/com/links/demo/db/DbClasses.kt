package com.links.demo.db


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/29 0029
 * 描    述：
 * 修订历史：
 * ================================================
 */
class CityForecast(val map: MutableMap<String, Any?>, val datForecast: List<DayForecast>) {
    var _id: Long by map
    var city: String by map
    var country: String by map

    /**
     * 这是因为我们需要从domain映射到数据库类中，所以不能使用map，
     * 从属性中设置值也是方便的。我们传入一个空的map，但是又一次，
     * 多亏了委托，当我们设置值到属性的时候，它会自动增加所有的值到map中。
     * 用这种方式，我们就准备好map来保存到数据库中了。使用了这些有用的代码，我将会看见它运行起来就像魔法一样神奇
     */
    constructor(id: Long, city: String, country: String, datForecast: List<DayForecast>)
            : this(HashMap(), datForecast) {
        this._id = id
        this.city = city
        this.country = country
    }
}

class DayForecast(var map: MutableMap<String, Any?>) {
    var date: Long by map
    var description: String by map
//    var _id: Long by map
    var high: Int by map
    var low: Int by map
    var icon: String by map
    var cityId: Long by map

    constructor(date: Long, decription: String, high: Int, low: Int, icon: String, cityId: Long) : this(HashMap()) {
        this.date = date
        this.description = decription
        this.high = high
        this.low = low
        this.icon = icon
        this.cityId = cityId
    }


}