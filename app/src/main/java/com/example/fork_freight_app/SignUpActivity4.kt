package com.example.fork_freight_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fork_freight_app.ModelRole.role
import com.example.fork_freight_app.databinding.ActivitySignUp4Binding
import com.google.gson.GsonBuilder
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class SignUpActivity4 : AppCompatActivity() {

    private lateinit var binding: ActivitySignUp4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pbar1.progress = 100
        binding.pbar2.progress = 100
        binding.pbar3.progress = 100

        binding.btnCancle4.setOnClickListener {
            var i = Intent(applicationContext,SignUpActivity3::class.java)
            startActivity(i)
        }
        binding.next4.setOnClickListener {
            var i = Intent(applicationContext,SignUpActivity4::class.java)
            binding.pbar4.progress = 100
            startActivity(i)
        }
    }
        private fun getRoleRetrofit(): Retrofit {
            var RetrofitBuilder = Retrofit.Builder()
                .baseUrl("http://52.14.255.158:9000/api/roleList")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
                .create(Role_api::class.java)
            val retrofitData=RetrofitBuilder.getRole()

            retrofitData.enqueue(object : Callback<List<role>?> {
                override fun onResponse(call: Call<List<role>?>, response: Response<List<role>?>) {
                    val responseBody=response.body()!!
                    var MyAdaper = RoleAdapter(baseContext,responseBody)
                }

                override fun onFailure(call: Call<List<role>?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }

}