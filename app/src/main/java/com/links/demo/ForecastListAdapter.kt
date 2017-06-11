package com.links.demo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.links.demo.ForecastListAdapter.ViewHolder
import com.links.demo.domain.Forecast
import com.links.demo.domain.ForecastList
import com.links.demo.listener.OnItemClickListener
import com.links.demo.listener.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import kotlin.links.com.demo.R

/**
 * Created by linksus on 6/7 0007.
 */
 class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return weekForecast.size()
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.ctx).inflate(R.layout.item_forecast, parent,false)
        return ViewHolder(view, itemClick)
    }

    class ViewHolder(view: View, val itemClick:(Forecast) -> Unit) : RecyclerView.ViewHolder(view) {
        private val iconView: ImageView  = view.find(R.id.icon)
        private val dateView: TextView = view.find(R.id.date)
        private val descriptionView: TextView = view.find(R.id.description)
        private val maxTemperatureView: TextView = view.find(R.id.maxTemperature)
        private val minTemperatureView: TextView =  view.find(R.id.minTemperature)

//        init {
//            iconView = view.find(R.id.icon)
//            dateView = view.find(R.id.date)
//            descriptionView = view.find(R.id.description)
//            maxTemperatureView = view.find(R.id.maxTemperature)
//            minTemperatureView = view.find(R.id.minTemperature)
//        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}