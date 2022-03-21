package com.example.fork_freight_app

import com.example.fork_freight_app.ModelRole.role
import retrofit2.Call
import retrofit2.http.GET

interface Role_api {

    @GET("/roleList")
    fun getRole(): Call<List<role>>

}