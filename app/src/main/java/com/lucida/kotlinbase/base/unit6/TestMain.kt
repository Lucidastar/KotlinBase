package com.lucida.kotlinbase.base.unit6



fun main(args: Array<String>) {
    println("<top>.main")
    var v = A()
    test {
        println("test")
        return@test
        println("test1")
    }
    println("test")
    val test = Test<A>()
    test.add(A())
}

const val a = 12
object C{
    const val s = 0
}
class E{
    companion object{
        const val f = 0
    }
}


fun getValue(s:String?): String? {
    return "1" + s?.length
}

inline fun test(crossinline l:() ->Unit){
    l.invoke()
    return
}

inline fun test1(l0:() -> Unit, noinline l1:() -> Unit): () -> Unit {
    l0.invoke()
    l1.invoke()
    return l1
}

class Test<T> where T:CallBack , T:Runnable{
    fun add(t:T){
        t.run()
        t.callback()
    }

}
class A : CallBack ,Runnable{
    override fun callback() {
        println("A.callback")
    }

    override fun run() {
        println("A.run")
    }

}

interface CallBack{
    fun callback()
}




