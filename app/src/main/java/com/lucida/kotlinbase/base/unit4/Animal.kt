package com.lucida.kotlinbase.base.unit4

interface Animal {
    fun bark()
}

class Dag : Animal{
    override fun bark() {
        println("wwww")
    }
}

class Zoo(animal: Animal):Animal by animal{
    override fun bark() {
        println("zoo")
    }
}