package com.example.fork_freight_app.signupfragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.fork_freight_app.R
import com.example.fork_freight_app.activity.SignUpActivity
import com.example.fork_freight_app.databinding.Fragment1Binding


class Fragment1 : Fragment() {

    private lateinit var binding:Fragment1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

         binding = DataBindingUtil.inflate(inflater,R.layout.fragment_1, container, false)

        (activity as SignUpActivity?)!!.progress()

        binding.next1.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_fragment1_to_fragment2)
        }
        return binding.root

        binding.next1.setOnClickListener {}
    }


}