package com.lucida.kotlinbase.base.unit5

import java.io.File

fun main(args: Array<String>) {
//    testJG()
//    testMap()
//    testLoop()
//    testOperator()

    testScopeOperator()
}

fun testJG(){
    val user = User("hyli",12)
    val (age,name) = user
    println(age)
    println(name)

}

fun testMap(){
    val map = mapOf<String,String>("key" to "key","value" to "value")
    for ((k,v) in map){
        println(k+"---"+v)
    }
}

fun testLoop(): Unit {
    for ( i in 1..10){
        println(i)
    }
    for (i in 1 until 10){
    }
    for (i in 10 downTo 2){
    }
    for (i in 1..20 step 2){

    }
    repeat(10){
        println(it)
    }

    //这种就是解构的方式
    val list = arrayListOf<String>("a","b","c","d")
    for ((index,name) in list.withIndex()){
        println("第${index}元素是：${name}")
    }
}

fun testOperator(): Unit {
    val list = arrayListOf<Char>('a','b','c','d','e')
    val result = list
        .run { showResult(toList())}
        .map {it - 'a' }
        .filter { it > 0 }
        .find { it > 1 }
    println(result)
}

fun showResult(chars:List<Char>): List<Char> {
    for (char in chars){
        println("${char} == " + char.toInt())
    }
    return chars
}

//作用域操作符
fun testScopeOperator(): Unit {
    val user = User("hyli",12)
    //run和let都会返回闭包的执行结果，区别let有闭包参数，run没有闭包参数
    val runResult = user.run {
        this::class
    }
    println(runResult)
    val LetResut = user.let { user ->
        user::class
    }
    println(LetResut.toString())
    //also和apply都不返回执行结果，also有闭包参数，apply没有闭包参数
    user.also {
        user -> user.name = "also"
    }
    println(user.name)
    user.apply { this.name = "apply" }
    println(user.name)
    //takeIf的闭包返回一个判断结果，为false时，takeIf函数会返回空
    //takeUnless与takeIf相反 闭包的判断结果，为true时返回结果为空
    user.takeIf { user.name == "" }?.also { print(user.name) }
    user.takeUnless { user -> user.name == "" }
}

fun `1234`() {
    println("test")
    val file = A("")
}

public typealias A = File
