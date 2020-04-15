package com.lucida.kotlinbase.base.unit5

class User(var name:String,var age:Int) {
    operator fun component1() = name//代表第一个元素
    operator fun component2() = age//代表第二个元素
}