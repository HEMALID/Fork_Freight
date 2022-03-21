package com.example.fork_freight_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fork_freight_app.ModelRole.role
import com.example.fork_freight_app.databinding.ActivitySignUp3Binding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignUpActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivitySignUp3Binding
    private lateinit var myAdapter: RoleAdapter
    private lateinit var linearLayoutManager:LinearLayoutManager
    val BASE_URL = "http://52.14.255.158:9000/api/roleList"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pbar1.progress = 100
        binding.pbar2.progress = 100

        binding.btnCancle3.setOnClickListener {
            var i = Intent(applicationContext,SignUpActivity2::class.java)
            startActivity(i)
        }

        binding.next3.setOnClickListener {
            var i = Intent(applicationContext,SignUpActivity4::class.java)
            binding.pbar3.progress = 100
            startActivity(i)
        }

        binding.recyclersign3.setHasFixedSize(true)
        linearLayoutManager= LinearLayoutManager(this)
        binding.recyclersign3.layoutManager=linearLayoutManager
        getRetroInstance()

    }
    private fun getRetroInstance() {
        var logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        var okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logger)

        var retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
            .create(Role_api::class.java)

        val retrofitData=retrofitBuilder.getRole()

        retrofitData.enqueue(object : Callback<List<role>?> {
            override fun onResponse(call: Call<List<role>?>, response: Response<List<role>?>) {
                val responseBody=response.body()!!

                myAdapter= RoleAdapter(baseContext,responseBody)
                myAdapter.notifyDataSetChanged()
                binding.recyclersign3.adapter=myAdapter
            }

            override fun onFailure(call: Call<List<role>?>, t: Throwable) {
                Log.d("SignUpActivity3","onfailer"+t.message)
            }
        })

    }
}

