package com.links.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.links.demo.domain.ForecastList
import com.links.demo.network.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.longToast
import kotlin.links.com.demo.R
import kotlin.jvm.javaClass

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        main_text.text = add(5, 4).toString()
//        val person = Person("s", "s")
//        main_text.text = person.pritln(5, 5)
//        niceToast("Hello")
        initRecycleList()

//        jibenleixing()
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    var url = "http://samples.openweathermap.org/data/2.5/forecast?q=beijing,ZH&appid=b1b15e88fa797225412429c1c50c122a1"
    private fun getData() = async(UI) {
        val result = bg { RequestForecastCommand("94043").execute() } //在后台处理网络请求
        longToast("getDataSuccess")
        updateUI(result.await())
    }


    private fun updateUI(weekForecast: ForecastList) {
        forecast_list.adapter = ForecastListAdapter(weekForecast)
    }

    private fun initRecycleList() {
        forecast_list.layoutManager = LinearLayoutManager(this)
//        forecast_list.adapter = ForecastListAdapter(items)
    }

    /**
     * 得到一个 list
     */
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun add2(x: Int, y: Int): Int = x + y

    /**
     * 我们可以给参数指定一个默认值使得它们变得可选，这是非常有帮助的
     */
    fun showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

    fun niceToast(message: String, tag: String = javaClass.simpleName, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "[$tag]$message", length).show()
    }

    private val FLAG1: Boolean = true
    private val FLAG2: Boolean = false

    fun jibenleixing() {

        print("jibenleixing")
        /**
         * .数字类型中不会自动转型。举个例子，你不能给Double变量分配一个Int。必须要做一个明确的类型转换，可以使用众多的函数之一
         */
        val i: Int = 7
        val d: Double = i.toDouble()

        /**
         * .字符（Char）不能直接作为一个数字来处理。在需要时我们需要把他们转换为一个数字
         */
        val c: Char = 'c'
        val i2: Int = c.toInt()

        /**
         * .位运算也有一点不同。在Android中，我们经常在flags中使用“或”，所以我使用"and"和"or来举例
         * 还有很多其他的位操作符，比如sh1  - java(<<), shr - java(>>),shs, ushr, xor或inv
         */
        val bitwiseOr: Boolean = FLAG1 or FLAG2
        val bitwiseAnd: Boolean = FLAG1 and FLAG2

        /**
         * .字面上可以写明具体的类型。这个不是必须的，但是一个通用的Kotlin实践时省略变量的类型（我们马上就能看到），
         * 所以我们可以让编译器自己去推断出具体的类型。
         */
        val i3 = 12 //int
        val iHex = 0x0f //一个十六进制的int类型
        val l = 3L//Long
        val d2 = 3.5//double
        val f = 3.5f//float

        /**
         * .一个String可以像数组那样访问，并且被迭代
         */
        val s = "Example"
        val c2 = s[2]//这是一个字符‘a’
        print("$c2 bitwiseOr:$bitwiseOr bitwiseAnd:$bitwiseAnd")
        //迭代String
        for (c2 in s) {
            print("$c2 bitwiseOr:$bitwiseOr bitwiseAnd:$bitwiseAnd")
        }

    }
}
