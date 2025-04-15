package com.faruk.miwok.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faruk.miwok.databinding.ItemWordBinding
import com.faruk.miwok.model.data.Word

class WordAdapter(
    private val categoryColor: Int,
    private val onClick: (Word) -> Unit
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var wordList: List<Word> = emptyList()

    fun submitList(words: List<Word>) {
        wordList = words
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(wordList[position])
    }

    override fun getItemCount(): Int = wordList.size

    inner class WordViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

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
