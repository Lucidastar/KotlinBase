package com.lucida.kotlinbase.base.unit4

class Single private constructor(){
    companion object{
        fun get():Single{
            return Holder.instance
        }
    }
    private object Holder{
        val instance = Single()
    }
}