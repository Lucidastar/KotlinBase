package com.lucida.kotlinbase

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.lruCache
import androidx.core.view.forEach
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.prefs.Preferences
import kotlin.math.round

class MainActivity: AppCompatActivity() {

    lateinit var mHeadView : ImageView//使用时保证不为空
    val mUrl:String = ""
    init {
        println("执行构造函数的初始化的工作")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intent.getStringExtra("");
        val double = round(2.0f) as Double
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                val bitmap = getImage(mUrl)
                also {

                }
            }


        }.also {

        }

//        iv.setImageBitmap(b)
    }

    fun getImage(url: String) :Bitmap{
        val urlParams = URL(url)
        val connection = urlParams.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.readTimeout=2000
        connection.connect()
        val inputStream = connection.inputStream
        return BitmapFactory.decodeStream(inputStream)
    }


    fun getContent(v:View) {

    }

    fun getFile(url: String) : Boolean{
//        val sharedPreferences = getSharedPreferences("catch_name", Context.MODE_PRIVATE)
//        sharedPreferences.edit().putBoolean("name",true)
        var linearLayout = LinearLayout(this)
        linearLayout.forEach {


        }
        Thread{
            val url = URL(url)
            val openConnection = url.openConnection() as HttpURLConnection
            openConnection.connectTimeout = 2000
            openConnection.requestMethod = "GET"
            openConnection.readTimeout = 200
            val inputStream = openConnection.inputStream
            val bufferedOutputStream = BufferedInputStream(inputStream)
            val contentValues = ContentValues()

        }
        return false
    }

}

fun getContent(){

}
