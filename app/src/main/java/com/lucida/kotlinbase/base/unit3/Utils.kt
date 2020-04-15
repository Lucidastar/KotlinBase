package com.lucida.kotlinbase.base.unit3

import java.io.File
import java.nio.charset.Charset

fun echo(name: String = "lucia") = println(name)

fun main(args: Array<String>) {
    function()

}
fun function (): Unit {
    println("begin")
    fun say(count:Int = 10){
        println(count)
        if (count > 0){
            say(count - 1)
        }
    }
    say()
}

fun File.readText(charset: Charset = Charsets.UTF_8) :String = readBytes().toString(charset)