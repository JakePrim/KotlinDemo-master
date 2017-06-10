package com.links.demo

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.links.demo.ForecastListAdapter.ViewHolder
import com.links.demo.domain.ForecastList

/**
 * Created by linksus on 6/7 0007.
 */
class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return weekForecast.dailyForecast.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder != null) {
            /**
             * with是一个非常有用的函数，它包含在Kotlin的标准库中。
             * 它接收一个对象和一个扩展函数作为它的参数，然后使这个对象扩展这个函数。
             * 这表示所有我们在括号中编写的代码都是作为对象（第一个参数）的一个扩展函数，
             * 我们可以就像作为this一样使用所有它的public方法和属性。
             * 当我们针对同一个对象做很多操作的时候这个非常有利于简化代码。
             */
            with(weekForecast.dailyForecast[position]) {
                holder.textview.text = "$date - $description - $high/$low"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    class ViewHolder(val textview: TextView) : RecyclerView.ViewHolder(textview)
}