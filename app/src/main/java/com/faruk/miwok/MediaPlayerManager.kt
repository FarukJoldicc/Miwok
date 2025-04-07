package com.faruk.miwok

import android.content.Context
import android.media.MediaPlayer

object MediaPlayerManager {
    private var mediaPlayer: MediaPlayer? = null

    fun playSound(context: Context, fileName: String) {
        release()

        val resId = context.resources.getIdentifier(fileName, "raw", context.packageName)
        if (resId == 0) return

        mediaPlayer = MediaPlayer.create(context, resId).apply {
            setOnCompletionListener {
                release()
            }
            start()
        }
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
