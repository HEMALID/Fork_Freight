package com.example.fork_freight_app.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fork_freight_app.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            var i = Intent(applicationContext, LoginActivity::class.java)
            startActivity(i)
        }
        binding.btnSignup.setOnClickListener {
            var i = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(i)
        }


    }
}