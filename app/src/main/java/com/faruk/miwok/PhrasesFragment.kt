package com.faruk.miwok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PhrasesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("Where are you going?", "minto wuksus"),
            Word("What is your name?", "tinnә oyaase'nә"),
            Word("My name is...", "oyaaset..."),
            Word("How are you feeling?", "michәksәs?"),
            Word("I'm feeling good.", "kuchi achit"),
            Word("Are you coming?", "әәnәs'aa?"),
            Word("Yes, I'm coming.", "hәә’ әәnәm"),
            Word("I'm coming.", "әәnәm"),
            Word("Let's go.", "yoowutis"),
            Word("Come here.", "әnni'nem")
        )

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = WordAdapter(words)

        return rootView
    }
}
