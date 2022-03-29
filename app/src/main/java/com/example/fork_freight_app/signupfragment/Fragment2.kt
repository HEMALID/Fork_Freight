package com.example.fork_freight_app.signupfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.fork_freight_app.R
import com.example.fork_freight_app.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_2, container, false)
        binding.next2.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_fragment2_to_fragment3)
        }

        return binding.root
    }

}