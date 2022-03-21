package com.example.fork_freight_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fork_freight_app.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancle1.setOnClickListener {
            var i = Intent(applicationContext,LandingActivity::class.java)
            startActivity(i)
        }
        binding.next1.setOnClickListener {
            var i = Intent(applicationContext,SignUpActivity2::class.java)
            binding.pbar1.progress = 100
            startActivity(i)
        }

    }

}