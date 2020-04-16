package com.lucida.kotlinbase.base.unit6

class View<T>(val clazz : Class<T>) {
    //运行时获取到class
    val presenter by lazy { clazz.newInstance() }
    companion object{
        inline operator fun <reified T> invoke() = View(T::class.java)
    }
}
class Presenter{
    override fun toString(): String {
        return super.toString()
    }
}

fun main(args: Array<String>) {
    val p = View<Presenter>().presenter
}