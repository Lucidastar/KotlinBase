package com.lucida.kotlinbase.base.unit4

fun main(args: Array<String>) {
    StringUtils.isEmpty("hello")
    Single.get()

    //代理的调用
    Zoo(Dag()).bark()

}