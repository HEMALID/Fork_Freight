package com.example.fork_freight_app.role.modelrole

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fork_freight_app.role.RoleAdapter
import com.example.fork_freight_app.role.RoleApi
import com.example.fork_freight_app.role.RoleInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoleViewModel : ViewModel() {

    lateinit var recyclerListData: MutableLiveData<Role>
    lateinit var roleAdapter: RoleAdapter

    init {
        recyclerListData = MutableLiveData()
        roleAdapter = RoleAdapter()
    }
    fun getAdapter(): RoleAdapter {
        return roleAdapter
    }
    fun setAdapterData(data: ArrayList<Role>){
        roleAdapter.setDataList(data)
        roleAdapter.notifyDataSetChanged()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<Role> {
        return recyclerListData
    }

    fun makeApiCall(input: String) {

        val retroInstance = RoleInstance.getRetroInstance().create(RoleApi::class.java)
        val call = retroInstance.getRole(input)
        call.enqueue(object : Callback<Role?> {
            override fun onResponse(call: Call<Role?>, response: Response<Role?>) {
               if (response.isSuccessful){
                   recyclerListData.postValue(response.body())
               }else{
                   recyclerListData.postValue(null)
               }
            }

            override fun onFailure(call: Call<Role?>, t: Throwable) {
                recyclerListData.postValue(null)
            }
        })


    }
}