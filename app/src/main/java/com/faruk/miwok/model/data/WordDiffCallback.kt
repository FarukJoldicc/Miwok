package com.faruk.miwok.model.data

import androidx.recyclerview.widget.DiffUtil

class WordDiffCallback : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        // Check if items are the same (e.g., by ID or unique identifier)
        return oldItem.soundFileName == newItem.soundFileName
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        // Check if the contents of the items are the same
        return oldItem == newItem
    }
}