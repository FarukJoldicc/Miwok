package com.faruk.miwok

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.core.content.ContextCompat

class FamilyFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var adapter: WordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = listOf(
            Word("father", "әpә", R.drawable.family_father, "Family", "family_father"),
            Word("mother", "әṭa", R.drawable.family_mother, "Family", "family_mother"),
            Word("son", "angsi", R.drawable.family_son, "Family", "family_son"),
            Word("daughter", "tune", R.drawable.family_daughter, "Family", "family_daughter"),
            Word("older brother", "taachi", R.drawable.family_older_brother, "Family", "family_older_brother"),
            Word("younger brother", "chalitti", R.drawable.family_younger_brother, "Family", "family_younger_brother"),
            Word("older sister", "teṭe", R.drawable.family_older_sister, "Family", "family_older_sister"),
            Word("younger sister", "kolliti", R.drawable.family_younger_sister, "Family", "family_younger_sister"),
            Word("grandmother", "ama", R.drawable.family_grandmother, "Family", "family_grandmother"),
            Word("grandfather", "paapa", R.drawable.family_grandfather, "Family", "family_grandfather")
        )

        setupRecyclerView(rootView, words, R.color.category_family)
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
