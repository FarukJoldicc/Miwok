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

        // Log for debugging purposes
        Log.d("WordAdapter", "Word at position $position: ${word.miwokTranslation}, Category: ${word.category}, Image Resource: ${word.imageResourceId}")

        with(holder.binding) {
            wordTextView.text = word.miwokTranslation
            translationTextView.text = word.defaultTranslation

            val color = ContextCompat.getColor(context, categoryColor)
            listItemContainer.setBackgroundColor(color)

            // Always hide the image by default
            imageView.visibility = android.view.View.GONE

            // Only show image if not "Phrases" and imageResourceId is valid
            if (word.category != "Phrases" && word.imageResourceId != 0) {
                imageView.setImageResource(word.imageResourceId)
                imageView.visibility = android.view.View.VISIBLE
            }

            listItemContainer.setOnClickListener {
                MediaPlayerManager.playSound(context, word.soundFileName)
            }
        }
    }
}
