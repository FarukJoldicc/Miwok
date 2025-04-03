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

class PhrasesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("Where are you going?", "minto wuksus", category = "Phrases"),
            Word("What is your name?", "tinnә oyaase'nә", category = "Phrases"),
            Word("My name is...", "oyaaset...", category = "Phrases"),
            Word("How are you feeling?", "michәksәs?", category = "Phrases"),
            Word("I'm feeling good.", "kuchi achit", category = "Phrases"),
            Word("Are you coming?", "әәnәs'aa?", category = "Phrases"),
            Word("Yes, I'm coming.", "hәә’ әәnәm", category = "Phrases"),
            Word("I'm coming.", "әәnәm", category = "Phrases"),
            Word("Let's go.", "yoowutis", category = "Phrases"),
            Word("Come here.", "әnni'nem", category = "Phrases")
        )

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = WordAdapter(words, R.color.category_phrases)

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
