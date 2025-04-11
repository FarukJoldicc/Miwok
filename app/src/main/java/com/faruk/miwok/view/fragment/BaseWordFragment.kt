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
        val categoryColor = arguments?.getInt(ARG_COLOR) ?: 0

        adapter = WordAdapter(requireContext(), categoryColor)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@BaseWordFragment.adapter

            ContextCompat.getDrawable(requireContext(), R.drawable.black_divider)?.let {
                addItemDecoration(CustomDividerItemDecoration(it))
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

        MediaPlayerManager.release()
    }

    companion object {
        private const val ARG_CATEGORY = "category"
        private const val ARG_COLOR = "color"

        fun newInstance(category: String, categoryColor: Int): BaseWordFragment {
            val fragment = BaseWordFragment()
            val args = Bundle()
            args.putString(ARG_CATEGORY, category)
            args.putInt(ARG_COLOR, categoryColor)
            fragment.arguments = args
            return fragment
        }
    }
}
