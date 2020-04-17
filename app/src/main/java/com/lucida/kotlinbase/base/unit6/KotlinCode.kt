
@file:JvmName("KotlinCode")

package com.lucida.kotlinbase.base.unit6

import android.os.AsyncTask
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.coroutines.CoroutineContext

object TestOther{
    fun sayMessage(): Unit {
        println("Test.sayMessage")
    }
}

fun doFunction(block:(e : Int) -> Unit){
    block.invoke(1)
}

val channel = Channel<Runnable>(1)
abstract class Task : Runnable
abstract class UI : Runnable

suspend fun async(task: Task){
    channel.send(task)
}

suspend fun ui(ui: UI){
    channel.send(ui)
}


fun start() {
    GlobalScope.launch(AndroidCommonPool) {
        while (true){
            val t = channel.receive()
            when(t){
                is UI -> launch(UI) {
                    t.run()
                }
                is Task -> launch {
                    t.run()
                }
            }
        }
    }
}

object AndroidCommonPool : CoroutineDispatcher(){
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(block)
    }

}
