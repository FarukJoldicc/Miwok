package com.faruk.miwok.numbers.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.faruk.miwok.R
import com.faruk.miwok.adapter.WordAdapter
import com.faruk.miwok.components.CustomDividerItemDecoration
import com.faruk.miwok.components.MediaPlayerManager
import com.faruk.miwok.data.Word
import com.faruk.miwok.numbers.presenter.NumbersContract
import com.faruk.miwok.numbers.presenter.NumbersPresenter

class NumbersFragment : Fragment(), NumbersContract.View {

    private lateinit var adapter: WordAdapter
    private lateinit var presenter: NumbersContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)
        setupRecyclerView(rootView)

        presenter = NumbersPresenter(this)
        presenter.loadWords()

        return rootView
    }

    private fun setupRecyclerView(rootView: View) {
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        adapter = WordAdapter(requireContext(), emptyList(), R.color.category_numbers)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        ContextCompat.getDrawable(requireContext(), R.drawable.black_divider)?.let {
            recyclerView.addItemDecoration(CustomDividerItemDecoration(it))
        }
    }

    override fun showWords(words: List<Word>) {
        adapter.updateWords(words)
    }

    override fun onPause() {
        super.onPause()
        MediaPlayerManager.release()
    }

    override fun onDestroyView() {
        presenter.onDestroy()
        super.onDestroyView()
    }
}
