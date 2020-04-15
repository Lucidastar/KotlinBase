package com.lucida.kotlinbase.base.unit3

import android.view.View
import java.io.File

fun main(args: Array<String>) {
    NumImp.numInterface.getNum(12)
    View::class.constructors.forEach{
        println(it.parameters)
    }
    var file = File("local.properties")
    println(file.readText(Charsets.UTF_8))

    echoSub("hello word")
    lambdaStatement(true){
        String.format("我的年龄是%d岁",12)
    }
    lambdaStatement(true,{String.format("我的年龄是%d岁",12)})

    val runnable = Runnable { println("runnable:run") }
    val func:() -> Unit //声明一个没有返回值的表达式
    func = runnable::run

}

fun testLambda(){
    val thread = Thread(){

    }
    val thread2 = Thread{

    }
    val thread3 = Thread {
        -> Unit
    }

}
val echoSub = {string : String ->
    println(string.subSequence(IntRange(0,2)))}
//lambda的声明
inline fun lambdaStatement(isShowName: Boolean,block:() ->String){
    if (isShowName){
        println(block())
    }
}


