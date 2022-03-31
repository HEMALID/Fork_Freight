package com.example.fork_freight_app.activity

import android.R
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fork_freight_app.databinding.*
import com.google.android.material.internal.ContextUtils.getActivity
import java.security.AccessController.getContext


class SignUpActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancle.setOnClickListener {
            var i= Intent(applicationContext,LoginActivity::class.java)
            startActivity(i)
        }

        var progressBar = ProgressBar(this@SignUpActivity, null, R.attr.progressBarStyleSmall)

    }

    fun progress(){
        binding.pbar1.progress = 100
        binding.pbar2.progress = 0
        binding.pbar3.progress = 0
        binding.pbar4.progress = 0

    }
    fun progress2(){
        binding.pbar1.progress = 100
        binding.pbar2.progress = 100
        binding.pbar3.progress = 0
        binding.pbar4.progress = 0

    }
    fun progress3(){
        binding.pbar1.progress = 100
        binding.pbar2.progress = 100
        binding.pbar3.progress = 100
        binding.pbar4.progress = 0

    }
    fun progress4(){
        binding.pbar1.progress = 100
        binding.pbar2.progress = 100
        binding.pbar3.progress = 100
        binding.pbar4.progress = 100

    }



}