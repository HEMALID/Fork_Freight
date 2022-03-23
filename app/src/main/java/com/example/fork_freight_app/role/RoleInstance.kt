package com.example.fork_freight_app.role

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RoleInstance {

    companion object {

        var logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        var okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logger)

        fun getRetroInstance(): Retrofit {
            val BASE_URL = "http://52.14.255.158:9000/api/roleList"
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build()
        }
    }

}