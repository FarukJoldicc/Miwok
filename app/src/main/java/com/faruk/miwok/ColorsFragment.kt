package com.faruk.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration

class ColorsFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var adapter: WordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("red", "weṭeṭṭi", R.drawable.color_red, "Colors", "color_red"),
            Word("green", "chokokki", R.drawable.color_green, "Colors", "color_green"),
            Word("brown", "ṭakaakki", R.drawable.color_brown, "Colors", "color_brown"),
            Word("gray", "ṭopoppi", R.drawable.color_gray, "Colors", "color_gray"),
            Word("black", "kululli", R.drawable.color_black, "Colors", "color_black"),
            Word("white", "kelelli", R.drawable.color_white, "Colors", "color_white"),
            Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, "Colors", "color_dusty_yellow"),
            Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, "Colors", "color_mustard_yellow")
        )

        setupRecyclerView(rootView, words, R.color.category_colors)
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
        adapter.releaseMediaPlayer()  // Stop audio when app goes into background
    }
}
