package com.neppplus.pizzaorderapp_20220221

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvents()
        setValues()
    }

    fun setupEvents(){

//        splash 동작
        val myHandler = Handler(Looper.getMainLooper())
        myHandler.postDelayed({

          val myIntent = Intent(this, MainActivity::class.java)
          startActivity(myIntent)

        },3000)

    }

    fun setValues(){

    }

}