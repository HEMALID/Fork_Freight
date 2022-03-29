package com.example.fork_freight_app.role.modelrole

import com.google.gson.annotations.SerializedName

data class Role(
    @SerializedName("display_name")
    val displayName: String,
    val description: String )
