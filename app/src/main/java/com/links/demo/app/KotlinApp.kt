package com.links.demo.app

import android.app.Application


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/13 0013
 * 描    述：Applicaton单例化
 * 修订历史：
 * ================================================
 */
class KotlinApp : Application() {

    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}