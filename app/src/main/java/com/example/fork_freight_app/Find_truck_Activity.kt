package com.example.fork_freight_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fork_freight_app.Fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class Find_truck_Activity : AppCompatActivity() {

    private val brokers = Brokers_fg()
    private val findTruck = FindTruck_fg()
    private val myShipment = My_shipment_fg()
    private val setting = Setting_fg()
    private val trackMyLoad = Track_my_load_fg()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_truck)

        var bottom_nav=findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
               R.id.brokers -> replaceFrahment(brokers)
                R.id.find_truck -> replaceFrahment(findTruck)
                R.id.my_shipment -> replaceFrahment(myShipment)
                R.id.setting -> replaceFrahment(setting)
                R.id.track_my_load -> replaceFrahment(trackMyLoad)
            }
            true
        }
    }
    private fun replaceFrahment(fragment: Fragment){
        if (fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}