package com.faruk.miwok

import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NumbersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("One", "Lutti", R.drawable.number_one, "Numbers"),
            Word("Two", "Oṭiiko", R.drawable.number_two, "Numbers"),
            Word("Three", "Tolookosu", R.drawable.number_three, "Numbers"),
            Word("Four", "Oyyisa", R.drawable.number_four, "Numbers"),
            Word("Five", "Massokka", R.drawable.number_five, "Numbers"),
            Word("Six", "Temmokka", R.drawable.number_six, "Numbers"),
            Word("Seven", "Kenekaku", R.drawable.number_seven, "Numbers"),
            Word("Eight", "Kawinta", R.drawable.number_eight, "Numbers"),
            Word("Nine", "Wo’e", R.drawable.number_nine, "Numbers"),
            Word("Ten", "Na’aacha", R.drawable.number_ten, "Numbers")
        )

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = WordAdapter(words, R.color.category_numbers)

        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.black_divider)
        drawable?.let {
            val insetDivider = InsetDrawable(it, 0, 0, 0, 0) // Adds left and right padding
            divider.setDrawable(insetDivider)
        }
        recyclerView.addItemDecoration(divider)

        return rootView
    }
}
