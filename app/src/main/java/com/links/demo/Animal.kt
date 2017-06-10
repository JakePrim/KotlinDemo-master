package com.links.demo

/**
 * Created by linksus on 6/6 0006.
 * noteClass:默认任何类都是基础继承自Any（与java中的Object类似），
 * 但是我们可以继承其它类。所有的类默认都是不可继承的（final），
 * 所以我们只能继承那些明确声明open或者abstract的类
 */
public abstract class   Animal(name: String) {
    public abstract fun pritln(x: Int, y: Int): String
}