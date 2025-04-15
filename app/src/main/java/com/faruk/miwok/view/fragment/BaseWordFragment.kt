package com.faruk.miwok.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.faruk.miwok.databinding.FragmentBaseWordBinding
import com.faruk.miwok.viewmodel.WordViewModel
import com.faruk.miwok.view.components.CustomDividerItemDecoration
import kotlinx.coroutines.launch
import com.faruk.miwok.R
import com.faruk.miwok.view.components.MediaPlayerManager
import com.faruk.miwok.view.adapter.WordAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseWordFragment : Fragment() {

    private var _binding: FragmentBaseWordBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WordViewModel by viewModels()
    private lateinit var adapter: WordAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBaseWordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = arguments?.getString(ARG_CATEGORY) ?: ""
        val categoryColorResId = arguments?.getInt(ARG_COLOR) ?: 0
        val categoryColor = ContextCompat.getColor(requireContext(), categoryColorResId)

        adapter = WordAdapter(categoryColor) { word ->
            MediaPlayerManager.playSound(requireContext(), word.soundFileName)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@BaseWordFragment.adapter

            // Add custom divider
            val divider = ContextCompat.getDrawable(requireContext(), R.drawable.black_divider)
            if (divider != null) {
                addItemDecoration(CustomDividerItemDecoration(divider))
            }
        }

        viewModel.setCategory(category)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.words.collect { words ->
                adapter.submitList(words)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        MediaPlayerManager.release()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_CATEGORY = "category"
        private const val ARG_COLOR = "color"

        fun newInstance(category: String, categoryColor: Int): BaseWordFragment {
            val fragment = BaseWordFragment()
            fragment.arguments = Bundle().apply {
                putString(ARG_CATEGORY, category)
                putInt(ARG_COLOR, categoryColor)
            }
            return fragment
        }
    }
}
