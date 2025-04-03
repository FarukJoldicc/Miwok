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

class FamilyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("Father", "әpә", R.drawable.family_father, "Family"),
            Word("Mother", "әṭa", R.drawable.family_mother, "Family"),
            Word("Son", "angsi", R.drawable.family_son, "Family"),
            Word("Daughter", "tune", R.drawable.family_daughter, "Family"),
            Word("Older Brother", "taachi", R.drawable.family_older_brother, "Family"),
            Word("Younger Brother", "chalitti", R.drawable.family_younger_brother, "Family"),
            Word("Older Sister", "teṭe", R.drawable.family_older_sister, "Family"),
            Word("Younger Sister", "kolliti", R.drawable.family_younger_sister, "Family"),
            Word("Grandmother", "ama", R.drawable.family_grandmother, "Family"),
            Word("Grandfather", "paapa", R.drawable.family_grandfather, "Family")
        )

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = WordAdapter(words, R.color.category_family)

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
