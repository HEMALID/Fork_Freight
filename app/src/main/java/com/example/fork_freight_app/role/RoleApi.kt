package com.example.fork_freight_app.role

import com.example.fork_freight_app.role.modelrole.Role
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RoleApi {

    @GET("roleList")
    fun getRole(@Query("q")query: String): Call<Role>

}