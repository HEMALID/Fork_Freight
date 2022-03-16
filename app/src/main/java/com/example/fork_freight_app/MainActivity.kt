package com.example.fork_freight_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
             var i = Intent(applicationContext,LandingActivity::class.java)
             startActivity(i)
             finish()
        },3000)

    }
}