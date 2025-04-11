package com.faruk.miwok.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.faruk.miwok.components.MediaPlayerManager
import com.faruk.miwok.data.Word
import com.faruk.miwok.data.WordDiffCallback
import com.faruk.miwok.databinding.ListItemBinding

class WordAdapter(
    private val context: Context,
    private val categoryColor: Int
) : ListAdapter<Word, WordAdapter.ViewHolder>(WordDiffCallback()) {

    inner class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = getItem(position)

        with(holder.binding) {
            wordTextView.text = word.miwokTranslation
            translationTextView.text = word.defaultTranslation

            val color = ContextCompat.getColor(context, categoryColor)
            listItemContainer.setBackgroundColor(color)

            if (word.category == "Phrases") {
                imageView.visibility = android.view.View.GONE
            } else if (word.imageResourceId != null && word.imageResourceId != 0) {
                imageView.setImageResource(word.imageResourceId)
                imageView.visibility = android.view.View.VISIBLE
            } else {
                imageView.visibility = android.view.View.GONE
            }

            listItemContainer.setOnClickListener {
                MediaPlayerManager.playSound(context, word.soundFileName)
            }
        }
    }
}
