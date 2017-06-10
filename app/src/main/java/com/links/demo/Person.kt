package com.links.demo

/**
 * Created by linksus on 6/6 0006.
 * nateclass:如何定义一个类
 */
class Person(name: String, surname: String) : Animal(name) {


    override fun pritln(x: Int, y: Int): String {
        return (x + y).toString()
    }


    init {
        //构造函数的函数体
    }

}