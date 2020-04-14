package com.lucida.kotlinbase.base.unit2

fun main(args: Array<String>) {
    println("utils")
    Test.say("sayKt")
    //kotlin中调用java的class参数
    checkClass(TestDemo::class.java)
}
