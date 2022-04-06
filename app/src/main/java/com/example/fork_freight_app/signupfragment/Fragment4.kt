package com.example.fork_freight_app.signupfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fork_freight_app.R
import com.example.fork_freight_app.activity.FindTruckActivity
import com.example.fork_freight_app.activity.SignUpActivity
import com.example.fork_freight_app.databinding.Fragment4Binding
import com.example.fork_freight_app.equipment.EquipmentAdapter
import com.example.fork_freight_app.equipment.EquipmentApi
import com.example.fork_freight_app.equipment.modelequipment.EquipmentResponse
import com.example.fork_freight_app.equipment.modelequipment.Modelx
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BaseUrl = "http://52.14.255.158:9000/api/"

class Fragment4 : Fragment() {

    private lateinit var binding: Fragment4Binding
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: EquipmentAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    var items: List<Modelx> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_4, container, false)
        (activity as SignUpActivity?)!!.progress4()
        binding.next4.setOnClickListener {
            var i = Intent(context,FindTruckActivity::class.java)
            startActivity(i)
        }

        binding.recyclersign4.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        binding.recyclersign4.layoutManager = linearLayoutManager
        getMyData()
        return binding.root
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BaseUrl)
            .build()
            .create(EquipmentApi::class.java)

        val retrofitData = retrofitBuilder.getEqipment()
        retrofitData.enqueue(object : Callback<EquipmentResponse?> {
            override fun onResponse(
                call: Call<EquipmentResponse?>,
                response: Response<EquipmentResponse?>,
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()!!
                    val equipmentList = responseBody.data.equipment
                    myAdapter = EquipmentAdapter(equipmentList)
                    binding.recyclersign4.adapter = myAdapter

                }
            }

            override fun onFailure(call: Call<EquipmentResponse?>, t: Throwable) {
                Log.d("Fragment4", "onfailer" + t.message)
            }
        })

    }

}