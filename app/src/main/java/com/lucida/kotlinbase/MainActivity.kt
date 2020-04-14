package com.lucida.kotlinbase

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.net.HttpURLConnection
import java.net.URL
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val double = round(2.0f) as Double


    }

    fun getFile(url: String) : Boolean{
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
