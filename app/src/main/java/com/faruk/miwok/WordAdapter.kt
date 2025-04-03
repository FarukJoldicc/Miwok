package com.faruk.miwok

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.widget.LinearLayout


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
        holder.wordTextView.text = word.defaultTranslation
        holder.translationTextView.text = word.miwokTranslation

        // Set background color for each item (except Phrases)
        val color = ContextCompat.getColor(holder.itemView.context, categoryColor)
        holder.container.setBackgroundColor(color)

        // Set image visibility for non-Phrases items
        if (word.imageResourceId != null && word.imageResourceId != 0 && word.category != "Phrases") {
            holder.imageView.setImageResource(word.imageResourceId)
            holder.imageView.visibility = View.VISIBLE
        } else {
            holder.imageView.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = words.size
}
