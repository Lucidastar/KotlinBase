package com.lucida.kotlinbase.base.unit2

//定义一个函数
fun echo(name:String){
    println(name)
}

//匿名内部类的写法
object Test{
    fun say(string: String){
        println(string)
        with(StringBuilder()){

        }
    }
}

fun checkClass(clazz: Class<TestDemo>){
    println("传入了一个java的class:"+clazz.name)
}
