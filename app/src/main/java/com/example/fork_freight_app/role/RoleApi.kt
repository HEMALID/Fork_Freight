package com.example.fork_freight_app.role

import com.example.fork_freight_app.role.modelrole.RoleListResponse
import retrofit2.Call
import retrofit2.http.GET

interface RoleApi {

    @GET("roleList")
    fun getRole(): Call<RoleListResponse>

}