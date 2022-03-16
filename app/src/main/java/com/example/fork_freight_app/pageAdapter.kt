package com.example.fork_freight_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.fork_freight_app.fragment1.Fragment1
import com.example.fork_freight_app.fragment1.Fragment2
import com.example.fork_freight_app.fragment1.Fragment3
import com.example.fork_freight_app.fragment1.Fragment4

class pageAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 4;
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Fragment1()
            }
            1 -> {
                return Fragment2()
            }
            2 -> {
                return Fragment3()
            }
            3 -> {
                return Fragment4()
            }
            else -> {
                return Fragment1()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return ""
            }
            1 -> {
                return ""
            }
            2 -> {
                return ""
            }
            3 -> {
                return ""
            }
        }
        return super.getPageTitle(position)
    }
}
