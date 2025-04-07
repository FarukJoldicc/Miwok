package com.faruk.miwok.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.faruk.miwok.fragment.ColorsFragment
import com.faruk.miwok.fragment.FamilyFragment
import com.faruk.miwok.fragment.NumbersFragment
import com.faruk.miwok.fragment.PhrasesFragment

class CategoryAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NumbersFragment()
            1 -> FamilyFragment()
            2 -> ColorsFragment()
            3 -> PhrasesFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
