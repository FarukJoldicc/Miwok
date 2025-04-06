package com.faruk.miwok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FamilyFragment : BaseFragment() {

    private lateinit var adapter: WordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)

        val words = WordData.getWordsByCategory("Family")
        setupRecyclerView(rootView, words, R.color.category_family)

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
}
