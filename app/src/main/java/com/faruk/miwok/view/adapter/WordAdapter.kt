package com.faruk.miwok.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.faruk.miwok.databinding.ItemWordBinding
import com.faruk.miwok.model.data.Word
import com.faruk.miwok.model.data.WordDiffCallback

class WordAdapter(
    private val categoryColor: Int,
    private val onClick: (Word) -> Unit
) : ListAdapter<Word, WordAdapter.WordViewHolder>(WordDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class WordViewHolder(private val binding: ItemWordBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

        fun bind(word: Word) {
            binding.word = word
            binding.categoryColor = categoryColor
            binding.clickListener = View.OnClickListener {
                onClick(word)
            }
            binding.executePendingBindings()
        }
    }
}
