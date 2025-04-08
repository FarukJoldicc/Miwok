package com.faruk.miwok.phrases.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.faruk.miwok.R
import com.faruk.miwok.adapter.WordAdapter
import com.faruk.miwok.components.CustomDividerItemDecoration
import com.faruk.miwok.components.MediaPlayerManager
import com.faruk.miwok.data.Word
import com.faruk.miwok.phrases.presenter.PhrasesContract
import com.faruk.miwok.phrases.presenter.PhrasesPresenter
import com.faruk.miwok.databinding.WordListBinding

class PhrasesFragment : Fragment(), PhrasesContract.View {

    private var _binding: WordListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: WordAdapter
    private lateinit var presenter: PhrasesContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WordListBinding.inflate(inflater, container, false)
        setupRecyclerView()

        presenter = PhrasesPresenter(this)
        presenter.loadWords()

        return binding.root
    }

    private fun setupRecyclerView() {
        adapter = WordAdapter(requireContext(), emptyList(), R.color.category_phrases)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter

        ContextCompat.getDrawable(requireContext(), R.drawable.black_divider)?.let {
            binding.recyclerView.addItemDecoration(CustomDividerItemDecoration(it))
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
        _binding = null
        super.onDestroyView()
    }
}
