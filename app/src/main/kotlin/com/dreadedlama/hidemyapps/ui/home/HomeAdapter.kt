package com.dreadedlama.hidemyapps.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dreadedlama.hidemyapps.app.HailData.tags

class HomeAdapter(fragment: HomeFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = tags.size

    override fun createFragment(position: Int): Fragment = PagerFragment()
}