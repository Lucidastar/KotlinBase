package com.lucida.kotlinbase.base.unit1


var name = "lucida"
var age:Int = 15

var name1 : String? = null

fun main(args: Array<String>) {
//    name = name1!!
    test("hello")
}

fun test(string: String) : String{
    println("结果:${string}")
    return string
}