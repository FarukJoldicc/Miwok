package com.faruk.miwok.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.faruk.miwok.R
import com.faruk.miwok.adapter.WordAdapter
import com.faruk.miwok.components.CustomDividerItemDecoration
import com.faruk.miwok.components.MediaPlayerManager
import com.faruk.miwok.databinding.WordListBinding
import com.faruk.miwok.viewmodel.WordViewModel

class BaseWordFragment : Fragment() {

    companion object {
        private const val ARG_CATEGORY = "category"
        private const val ARG_COLOR = "color"

        fun newInstance(category: String, colorResId: Int) = BaseWordFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_CATEGORY, category)
                putInt(ARG_COLOR, colorResId)
            }
        }
    }

    private var _binding: WordListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: WordAdapter
    private val viewModel: WordViewModel by viewModels()
    private var colorResId: Int = R.color.category_numbers

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WordListBinding.inflate(inflater, container, false)

        val category = arguments?.getString(ARG_CATEGORY) ?: "Numbers"
        colorResId = arguments?.getInt(ARG_COLOR) ?: R.color.category_numbers

        adapter = WordAdapter(requireContext(), emptyList(), colorResId)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        ContextCompat.getDrawable(requireContext(), R.drawable.black_divider)?.let {
            binding.recyclerView.addItemDecoration(CustomDividerItemDecoration(it))
        }

        viewModel.setCategory(category)
        viewModel.words.observe(viewLifecycleOwner) {
            adapter.updateWords(it)
        }

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        MediaPlayerManager.release()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
