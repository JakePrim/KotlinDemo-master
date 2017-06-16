package com.links.demo.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.links.demo.app.KotlinApp
import org.jetbrains.anko.db.*


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/16 0016
 * 描    述：数据库的创建和更新
 * val dbHelper1 = ForecastDbHelper() // 它会使用 App.instance
 * val dbHelper2 = ForecastDbHelper(mockedContext) // 比如，提供给测试tests
 * 修订历史：
 * ================================================
 */
class ForecastDBHelper(ctx: Context = KotlinApp.instances) : ManagedSQLiteOpenHelper(KotlinApp.instances, ForecastDBHelper.DB_NAME, null, ForecastDBHelper.DB_VERSION) {


    /**
     * 创建数据库
     */
    override fun onCreate(db: SQLiteDatabase?) {
        /**
         *第一个参数是表的名称
         *第二个参数，当是true的时候，创建之前会检查这个表是否存在。
         *第三个参数是一个Pair类型的vararg参数。
         * vararg也存在在Java中，这是一种在一个函数中传入联系很多相同类型的参数。这个函数也接收一个对象数组。
         */

        /**
         * Kotlin标准库中包含了一个叫to的函数，又一次，让我们来展示Kotlin的强大之处。
         * 它作为第一参数的扩展函数，接收另外一个对象作为参数，把两者组装并返回一个Pair
         * public fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
         */
        db?.createTable(CityForecastTable.NAME, true
                , CityForecastTable.ID to INTEGER + PRIMARY_KEY
                , CityForecastTable.CITY to TEXT
                , CityForecastTable.COUNTRY to TEXT)

        db?.createTable(DayForecastTable.NAME, true, DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT
                , DayForecastTable.CITY_ID to INTEGER
                , DayForecastTable.DECRIPTION to TEXT
                , DayForecastTable.HIGH to INTEGER
                , DayForecastTable.LOW to INTEGER
                , DayForecastTable.ICON to TEXT
                , DayForecastTable.DATE to INTEGER)
    }

    /**
     * 更新数据库
     * 我们有一个相似的函数用于删除表。
     * onUpgrade将只是删除表，然后重建它们。
     * 我们只是把我们数据库作为一个缓存，所以这是一个简单安全的方法保证我们的表会如我们所期望的那样被重建。
     * 如果我有很重要的数据需要保留，我们就需要优化onUpgrade的代码，让它根据数据库版本来做相应的数据转移。
     */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(CityForecastTable.NAME, true)
        db?.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        /**
         * instance这个属性使用了lazy委托，它表示直到它真的被调用才会被创建。
         * 用这种方法，如果数据库从来没有被使用，我们没有必要去创建这个对象。
         * 一般lazy委托的代码块可以阻止在多个不同的线程中创建多个对象。
         * 这个只会发生在两个线程在同事时间访问这个instance对象，
         * 它很难发生但是发生具体还有看app的实现。lazy委托是线程安全的。
         */
        val instance: ForecastDBHelper by lazy { ForecastDBHelper() }
    }
}