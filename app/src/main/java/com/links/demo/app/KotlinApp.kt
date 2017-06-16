package com.links.demo.app

import android.app.Application
import com.links.demo.entrust.NotNullSingleValueVar
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/13 0013
 * 描    述：Applicaton
 * 修订历史：
 * ================================================
 */
class KotlinApp : Application() {

    companion object {
//        private var instance: Application? = null
//        fun instance() = instance!!
        /**
         * Application单例化
         */
        //by这个关键字来指定一个委托对象
        var instances: KotlinApp by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
//        instance = this
        instances = this
    }

    /**
     * 这种情况下有个问题，我们可以在app的任何地方去修改这个值，
     * 因为如果我们使用Delegates.notNull()，属性必须是var的。
     * 但是我们可以使用刚刚创建的委托，这样可以多一点保护。我们只能修改这个值一次：
     */
    object DelegatesExt {
        fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
    }
}