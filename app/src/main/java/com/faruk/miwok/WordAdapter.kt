package com.faruk.miwok

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.widget.LinearLayout
import android.graphics.Typeface

class WordAdapter(private val words: List<Word>, private val categoryColor: Int) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordTextView: TextView = itemView.findViewById(R.id.word_text_view)
        val translationTextView: TextView = itemView.findViewById(R.id.translation_text_view)
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val playButton: ImageView = itemView.findViewById(R.id.play_button)
        val container: LinearLayout = itemView.findViewById(R.id.list_item_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = words[position]

        // Ensure Miwok word is displayed in bold and white
        holder.wordTextView.text = word.miwokTranslation
        holder.wordTextView.setTypeface(null, Typeface.BOLD)
        holder.wordTextView.setTextColor(ContextCompat.getColor(holder.itemView.context, android.R.color.white))

        // Ensure English translation is displayed below and also white (but not bold)
        holder.translationTextView.text = word.defaultTranslation
        holder.translationTextView.setTextColor(ContextCompat.getColor(holder.itemView.context, android.R.color.white))
        holder.translationTextView.visibility = View.VISIBLE // Ensure visibility

        // Set background color for each item
        val color = ContextCompat.getColor(holder.itemView.context, categoryColor)
        holder.container.setBackgroundColor(color)

        // Hide the image for the "Phrases" category
        if (word.category == "Phrases") {
            holder.imageView.visibility = View.GONE
            holder.imageView.parent?.let { (it as View).visibility = View.GONE } // Hides the FrameLayout
        } else if (word.imageResourceId != null && word.imageResourceId != 0) {
            holder.imageView.setImageResource(word.imageResourceId)
            holder.imageView.visibility = View.VISIBLE
            holder.imageView.parent?.let { (it as View).visibility = View.VISIBLE } // Show the FrameLayout
        } else {
            holder.imageView.visibility = View.GONE
            holder.imageView.parent?.let { (it as View).visibility = View.GONE } // Ensures no empty container
        }
    }

    override fun getItemCount(): Int = words.size
}
