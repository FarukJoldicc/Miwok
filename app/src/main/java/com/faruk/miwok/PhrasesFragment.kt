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

class PhrasesFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var adapter: WordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("Where are you going?", "minto wuksus", null, "Phrases", "phrase_where_are_you_going"),
            Word("What is your name?", "tinnә oyaase'nә", null, "Phrases", "phrase_what_is_your_name"),
            Word("My name is...", "oyaaset...", null, "Phrases", "phrase_my_name_is"),
            Word("How are you feeling?", "michәksәs?", null, "Phrases", "phrase_how_are_you_feeling"),
            Word("I’m feeling good.", "kuchi achit", null, "Phrases", "phrase_im_feeling_good"),
            Word("Are you coming?", "әәnәs'aa?", null, "Phrases", "phrase_are_you_coming"),
            Word("Yes, I’m coming.", "hәә’ әәnәm", null, "Phrases", "phrase_yes_im_coming"),
            Word("I’m coming.", "әәnәm", null, "Phrases", "phrase_im_coming"),
            Word("Let’s go.", "yoowutis", null, "Phrases", "phrase_lets_go"),
            Word("Come here.", "әnni'nem", null, "Phrases", "phrase_come_here")
        )

        setupRecyclerView(rootView, words, R.color.category_phrases)
        return rootView
    }

    private fun setupRecyclerView(rootView: View, words: List<Word>, categoryColor: Int) {
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = WordAdapter(requireContext(), words, categoryColor, mediaPlayer)
        recyclerView.adapter = adapter

        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        ContextCompat.getDrawable(requireContext(), R.drawable.black_divider)?.let {
            divider.setDrawable(it)
        }
        recyclerView.addItemDecoration(divider)
    }

    override fun onStop() {
        super.onStop()
        adapter.releaseMediaPlayer()  // Stop audio when fragment stops
    }

    override fun onPause() {
        super.onPause()
        adapter.releaseMediaPlayer()  // Stop audio when app goes into background
    }
}
