package com.example.fork_freight_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fork_freight_app.databinding.ActivitySignUp2Binding

class SignUpActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivitySignUp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pbar1.progress = 100
        binding.btnCancle2.setOnClickListener {
            var i = Intent(applicationContext,SignUpActivity::class.java)
            startActivity(i)
        }
        binding.next2.setOnClickListener {
            var i = Intent(applicationContext,SignUpActivity3::class.java)
            binding.pbar2.progress = 100
            startActivity(i)
        }
    }
}