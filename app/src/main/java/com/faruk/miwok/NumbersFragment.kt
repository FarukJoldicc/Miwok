package com.faruk.miwok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NumbersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("One", "Lutti", R.drawable.number_one),
            Word("Two", "Oṭiiko", R.drawable.number_two),
            Word("Three", "Tolookosu", R.drawable.number_three),
            Word("Four", "Oyyisa", R.drawable.number_four),
            Word("Five", "Massokka", R.drawable.number_five),
            Word("Six", "Temmokka", R.drawable.number_six),
            Word("Seven", "Kenekaku", R.drawable.number_seven),
            Word("Eight", "Kawinta", R.drawable.number_eight),
            Word("Nine", "Wo’e", R.drawable.number_nine),
            Word("Ten", "Na’aacha", R.drawable.number_ten)
        )

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = WordAdapter(words)

        return rootView
    }
}
