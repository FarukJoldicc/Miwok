package com.faruk.miwok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ColorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("Red", "weṭeṭṭi", R.drawable.color_red),
            Word("Green", "chokokki", R.drawable.color_green),
            Word("Brown", "ṭakaakki", R.drawable.color_brown),
            Word("Gray", "ṭopoppi", R.drawable.color_gray),
            Word("Black", "kululli", R.drawable.color_black),
            Word("White", "kelelli", R.drawable.color_white),
            Word("Dusty Yellow", "ṭopiisә", R.drawable.color_dusty_yellow),
            Word("Mustard Yellow", "chiwiiṭә", R.drawable.color_mustard_yellow)
        )

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = WordAdapter(words)

        return rootView
    }
}
