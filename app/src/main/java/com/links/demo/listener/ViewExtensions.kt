package com.links.demo.listener

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.view.View
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 * Created by 17604 on 2017/6/11.
 * Anko提供了大量的扩展函数来让Android编程更简单。
 * 举个例子，activitys、fragments以及其它包含了ctx这个属性，
 * 通过ctx这个属性来返回context，但是在View中缺少这个属性。
 * 所以我们要创建一个新的名叫ViewExtensions.kt文件来代替ui.utils，然后增加这个扩展属性：
 */
val View.ctx: Context
    get() = context

fun <T : Any> SelectQueryBuilder.parseList(
        parser: (Map<String, Any?>) -> T): List<T> =
        parseList(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T {
                return parser(columns)
            }
        })

fun <T : Any> SelectQueryBuilder.parseOpt(
        parser: (Map<String, Any?>) -> T): T? =
        parseOpt(object : MapRowParser<T> {
            override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
        })

fun SQLiteDatabase.clear(tableName: String) {
    execSQL("delete from $tableName")
}

fun <K, V : Any> MutableMap<K, V?>.toVarargArray():
        Array<out Pair<K, V>> =  map({ Pair(it.key, it.value!!) }).toTypedArray()

inline fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?) : R {
    for (element in this){
        val result = predicate(element)
        if (result != null) return result
    }
    throw NoSuchElementException("No element matching predicate was found.")
}