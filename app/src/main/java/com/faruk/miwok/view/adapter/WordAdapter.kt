package com.faruk.miwok.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.faruk.miwok.view.components.MediaPlayerManager
import com.faruk.miwok.model.data.Word
import com.faruk.miwok.model.data.WordDiffCallback
import com.faruk.miwok.databinding.ListItemBinding
import android.util.Log
import android.view.View


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

            if (word.category != "Phrases" && word.imageResourceId != 0) {
                imageView.visibility = View.VISIBLE
                imageView.setImageResource(word.imageResourceId)
            } else {
                imageView.setImageDrawable(null)
                imageView.visibility = View.GONE
            }

            listItemContainer.setOnClickListener {
                MediaPlayerManager.playSound(context, word.soundFileName)
            }
        }
    }
}
