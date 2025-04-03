package com.faruk.miwok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FamilyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("Father", "әpә", R.drawable.family_father),
            Word("Mother", "әṭa", R.drawable.family_mother),
            Word("Son", "angsi", R.drawable.family_son),
            Word("Daughter", "tune", R.drawable.family_daughter),
            Word("Older Brother", "taachi", R.drawable.family_older_brother),
            Word("Younger Brother", "chalitti", R.drawable.family_younger_brother),
            Word("Older Sister", "teṭe", R.drawable.family_older_sister),
            Word("Younger Sister", "kolliti", R.drawable.family_younger_sister),
            Word("Grandmother", "ama", R.drawable.family_grandmother),
            Word("Grandfather", "paapa", R.drawable.family_grandfather)
        )

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = WordAdapter(words)

        return rootView
    }
}
