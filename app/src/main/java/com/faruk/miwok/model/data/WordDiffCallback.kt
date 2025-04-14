package com.faruk.miwok.model.data

import androidx.recyclerview.widget.DiffUtil

class WordDiffCallback : DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        // Use a unique identifier like id to compare the items
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        // Check if the contents of the items are the same
        return oldItem == newItem
    }
}
