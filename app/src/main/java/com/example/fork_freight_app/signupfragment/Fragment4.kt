package com.example.fork_freight_app.signupfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.fork_freight_app.R
import com.example.fork_freight_app.databinding.Fragment4Binding

class Fragment4 : Fragment() {

    private lateinit var binding:Fragment4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_4, container, false)
        binding.next4.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_fragment1_to_fragment2)
        }
        return binding.root
    }


}