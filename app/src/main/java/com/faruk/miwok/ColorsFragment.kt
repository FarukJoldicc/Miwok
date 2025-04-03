package com.faruk.miwok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.graphics.drawable.InsetDrawable

class ColorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("Red", "weṭeṭṭi", R.drawable.color_red, "Colors"),
            Word("Green", "chokokki", R.drawable.color_green, "Colors"),
            Word("Brown", "ṭakaakki", R.drawable.color_brown, "Colors"),
            Word("Gray", "ṭopoppi", R.drawable.color_gray, "Colors"),
            Word("Black", "kululli", R.drawable.color_black, "Colors"),
            Word("White", "kelelli", R.drawable.color_white, "Colors"),
            Word("Dusty Yellow", "ṭopiisә", R.drawable.color_dusty_yellow, "Colors"),
            Word("Mustard Yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, "Colors")
        )

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = WordAdapter(words, R.color.category_colors)

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
