package com.faruk.miwok

import android.media.MediaPlayer
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

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var adapter: WordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("one", "lutti", R.drawable.number_one, "Numbers", "number_one"),
            Word("two", "oṭiiko", R.drawable.number_two, "Numbers", "number_two"),
            Word("three", "tolookosu", R.drawable.number_three, "Numbers", "number_three"),
            Word("four", "oyyisa", R.drawable.number_four, "Numbers", "number_four"),
            Word("five", "massokka", R.drawable.number_five, "Numbers", "number_five"),
            Word("six", "temmokka", R.drawable.number_six, "Numbers", "number_six"),
            Word("seven", "kenekaku", R.drawable.number_seven, "Numbers", "number_seven"),
            Word("eight", "kawinta", R.drawable.number_eight, "Numbers", "number_eight"),
            Word("nine", "wo’e", R.drawable.number_nine, "Numbers", "number_nine"),
            Word("ten", "na’aacha", R.drawable.number_ten, "Numbers", "number_ten")
        )

        setupRecyclerView(rootView, words, R.color.category_numbers)
        return rootView
    }

    private fun setupRecyclerView(rootView: View, words: List<Word>, categoryColor: Int) {
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = WordAdapter(requireContext(), words, categoryColor, mediaPlayer)
        recyclerView.adapter = adapter

        // Re-add the divider
        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(requireContext(), R.drawable.black_divider)?.let {
            divider.setDrawable(it)
        }
        recyclerView.addItemDecoration(divider)
    }

    override fun onStop() {
        super.onStop()
        adapter.releaseMediaPlayer()
    }

    override fun onPause() {
        super.onPause()
        adapter.releaseMediaPlayer()
    }
}
