package com.lucida.kotlinbase.base.unit4

import android.content.Context
import android.util.AttributeSet
import android.view.View

class CustomView: View {
    constructor(context: Context) : super(context)
    constructor(context: Context,attrs:AttributeSet):this(context,attrs,0)
    constructor(context: Context,attrs: AttributeSet,defStyleInt: Int):super(context,attrs,defStyleInt)

}