package com.links.demo.db

import android.database.sqlite.SQLiteDatabase
import com.links.demo.app.KotlinApp
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
import org.jetbrains.anko.db.createTable


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/16 0016
 * 描    述：数据库的创建和更新
 * 修订历史：
 * ================================================
 */
class ForecastDBHelper : ManagedSQLiteOpenHelper(KotlinApp.instances, ForecastDBHelper.DB_NAME, null, ForecastDBHelper.DB_VERSION) {


    /**
     * 创建数据库
     */
    override fun onCreate(db: SQLiteDatabase?) {
//         db.createTable()
    }

    /**
     * 更新数据库
     */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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