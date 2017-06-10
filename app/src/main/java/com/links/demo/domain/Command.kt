package com.links.demo.domain

/**
 * Created by 17604 on 2017/6/10.
 */
public interface Command<T> {
    fun execute(): T
}