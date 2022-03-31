package com.example.fork_freight_app.signupfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fork_freight_app.R
import com.example.fork_freight_app.activity.SignUpActivity
import com.example.fork_freight_app.databinding.Fragment3Binding
import com.example.fork_freight_app.role.RoleAdapter
import com.example.fork_freight_app.role.RoleApi
import com.example.fork_freight_app.role.modelrole.RoleListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL ="http://52.14.255.158:9000/api/"
class Fragment3 : Fragment() {

    private lateinit var binding:Fragment3Binding
    private lateinit var manager:RecyclerView.LayoutManager
    private lateinit var myAdapter: RoleAdapter
    private lateinit var linearLayoutManager:LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_3, container, false)

        (activity as SignUpActivity?)!!.progress3()

        binding.next3.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_fragment3_to_fragment4)
        }

        binding.recyclersign3.setHasFixedSize(true)
        linearLayoutManager= LinearLayoutManager(context)
        binding.recyclersign3.layoutManager=linearLayoutManager
        getMyData()

        return binding.root
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RoleApi::class.java)

        val retrofitData=retrofitBuilder.getRole()
        retrofitData.enqueue(object : Callback<RoleListResponse> {
            override fun onResponse(
                call: Call<RoleListResponse>,
                response: Response<RoleListResponse>,
            ) {
                if (response?.isSuccessful!!){
                    val responseBody=response.body()!!
                    val roleList = responseBody.data.role
                    myAdapter= RoleAdapter(roleList)
                    myAdapter.notifyDataSetChanged()
                    binding.recyclersign3.adapter = myAdapter

                }
        }

            override fun onFailure(call: Call<RoleListResponse>, t: Throwable) {
                Log.d("Fragment3","onfailer"+t.message)
            }
        })
    }


}