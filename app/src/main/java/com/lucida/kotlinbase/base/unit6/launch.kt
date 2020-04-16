package com.lucida.kotlinbase.base.unit6

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking{
    val job = launch {
        repeat(10){
            println("hello 挂起中")
            delay(500)
        }

    }
    delay(3000)
    println("主线程等待中")
    job.cancel()

}

fun get(): Unit {
    GlobalScope.launch {

    }
}