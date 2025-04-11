package com.faruk.miwok.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.faruk.miwok.view.BaseWordFragment
import com.faruk.miwok.R

class CategoryAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BaseWordFragment.newInstance("Numbers", R.color.category_numbers)
            1 -> BaseWordFragment.newInstance("Family", R.color.category_family)
            2 -> BaseWordFragment.newInstance("Colors", R.color.category_colors)
            3 -> BaseWordFragment.newInstance("Phrases", R.color.category_phrases)
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
