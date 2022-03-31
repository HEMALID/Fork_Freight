package com.example.fork_freight_app.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.fork_freight_app.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
             var i = Intent(applicationContext, LandingActivity::class.java)
             startActivity(i)
             overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left)
             finish()
        },3000)

    }
}