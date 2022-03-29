package com.example.fork_freight_app.equipment

import com.example.fork_freight_app.equipment.modelequipment.EquipmentResponse
import retrofit2.Call
import retrofit2.http.GET

interface EquipmentApi {
    @GET("equipmentTypeList")
    fun getEqipment(): Call<EquipmentResponse>
}