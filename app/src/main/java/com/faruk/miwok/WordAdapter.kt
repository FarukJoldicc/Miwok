package com.faruk.miwok

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(
    private val context: Context,
    private val words: List<Word>,
    private val categoryColor: Int,
    private var mediaPlayer: MediaPlayer?
) : RecyclerView.Adapter<WordAdapter.ViewHolder>() {

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

        holder.wordTextView.text = word.miwokTranslation
        holder.translationTextView.text = word.defaultTranslation

        val color = ContextCompat.getColor(holder.itemView.context, categoryColor)
        holder.container.setBackgroundColor(color)

        if (word.category == "Phrases") {
            holder.imageView.visibility = View.GONE
        } else if (word.imageResourceId != null && word.imageResourceId != 0) {
            holder.imageView.setImageResource(word.imageResourceId)
            holder.imageView.visibility = View.VISIBLE
        } else {
            holder.imageView.visibility = View.GONE
        }

        val clickListener = View.OnClickListener {
            playSound(context, word.soundFileName)
        }

        holder.container.setOnClickListener(clickListener)
        holder.imageView.setOnClickListener(clickListener)
        holder.wordTextView.setOnClickListener(clickListener)
        holder.translationTextView.setOnClickListener(clickListener)
        holder.playButton.setOnClickListener(clickListener)
    }

    override fun getItemCount(): Int = words.size

    private fun playSound(context: Context, fileName: String) {
        mediaPlayer?.release()  // Stop and release the current media player
        mediaPlayer = null

        val resId = context.resources.getIdentifier(fileName, "raw", context.packageName)
        if (resId == 0) return

        mediaPlayer = MediaPlayer.create(context, resId).apply {
            setOnCompletionListener {
                release()
                mediaPlayer = null
            }
            start()
        }
    }

    fun releaseMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
