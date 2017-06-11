package com.links.demo.listener

import android.content.Context
import android.view.View

/**
 * Created by 17604 on 2017/6/11.
 * Anko提供了大量的扩展函数来让Android编程更简单。
 * 举个例子，activitys、fragments以及其它包含了ctx这个属性，
 * 通过ctx这个属性来返回context，但是在View中缺少这个属性。
 * 所以我们要创建一个新的名叫ViewExtensions.kt文件来代替ui.utils，然后增加这个扩展属性：
 */
val View.ctx: Context
    get() = context