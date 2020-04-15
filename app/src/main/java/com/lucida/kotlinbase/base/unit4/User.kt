package com.lucida.kotlinbase.base.unit4

data class User(var name:String,var age:Int)

enum class Command{
    A,B
}
fun getType(command: Command){
    when(command){
        Command.A -> println("a")
        Command.B -> println("b")
    }
}

sealed class SuperCommand{
    object A : SuperCommand()
    object B : SuperCommand()
    object C : SuperCommand()
    //密闭类可以扩展
    class E(var name :String): SuperCommand()
}
fun getSealed(superCommand: SuperCommand){
    when(superCommand){
        SuperCommand.A -> println("A")
        SuperCommand.B -> println("B")
        SuperCommand.C -> println("C")
        //通过构造可以传递参数
        SuperCommand.E("hello") -> println("E")
    }
}