package com.faruk.miwok.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.faruk.miwok.components.CustomDividerItemDecoration
import com.faruk.miwok.components.MediaPlayerManager
import com.faruk.miwok.R
import com.faruk.miwok.data.Word
import com.faruk.miwok.adapter.WordAdapter
import com.faruk.miwok.data.WordData

open class BaseFragment : Fragment() {

    private lateinit var adapter: WordAdapter

    open val categoryName: String = ""
    open val categoryColorResId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)
        val words = WordData.getWordsByCategory(categoryName)
        setupRecyclerView(rootView, words, categoryColorResId)
        return rootView
    }

    private fun setupRecyclerView(rootView: View, words: List<Word>, categoryColor: Int) {
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = WordAdapter(requireContext(), words, categoryColor)
        recyclerView.adapter = adapter

        val dividerDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.black_divider)
        dividerDrawable?.let {
            recyclerView.addItemDecoration(CustomDividerItemDecoration(it))
        }
    }

    override fun onPause() {
        super.onPause()
        MediaPlayerManager.release()
    }
}
