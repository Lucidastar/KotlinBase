package com.lucida.kotlinbase.base.unit1

import android.content.Context
import android.content.Intent
import com.lucida.kotlinbase.MainActivity
import java.io.File
import kotlin.concurrent.thread
import kotlin.math.round
import kotlin.reflect.KClass


fun main(args: Array<String>) {
    val double = round(2.0000)
    println(double)
    System.out.println("he" in "hello")
    Class.forName("")

    Thread{
        val result = repeat(2){
            with(StringBuilder()){
                append(1)
            }
            StringBuilder().apply {
                append(1)
                append(2)

            }
        }.let {
            println(it.toString())
        }
    }.start()
}

inline fun <reified T> startActivity(context:Context,block : Intent.() -> Unit){
    val intent = Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}

