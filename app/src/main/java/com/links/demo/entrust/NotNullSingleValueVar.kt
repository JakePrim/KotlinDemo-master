package com.links.demo.entrust

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 * ================================================
 * 作    者：linksus
 * 版    本：1.0
 * 创建日期：6/16 0016
 * 描    述：先来说说我们要实现什么，举个例子，我们创建一个notNull的委托，它只能被赋值一次，如果第二次赋值，它就会抛异常。
 * Kotlin库提供了几个接口，我们自己的委托必须要实现：
 * ReadOnlyProperty(val)和ReadWriteProperty(var)。具体取决于我们被委托的对象是val还是var。
 * 修订历史：
 * ================================================
 */
class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {

    private var value: T? = null
    /**
     * Getter函数 如果已经被初始化，则会返回一个值，否则会抛异常。
     * Setter函数 如果仍然是null，则赋值，否则会抛异常。
     */
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("already initialized")
    }
}