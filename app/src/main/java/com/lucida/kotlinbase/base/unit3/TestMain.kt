package com.lucida.kotlinbase.base.unit3

import android.view.View

fun main(args: Array<String>) {
    NumImp.numInterface.getNum(12)
    View::class.constructors.forEach{
        println(it.parameters)
    }
}
