package com.faruk.miwok

import android.content.Context
import android.media.MediaPlayer

object MediaPlayerManager {
    private var mediaPlayer: MediaPlayer? = null

    // Play the sound using the file name
    fun playSound(context: Context, fileName: String) {
        release()  // Release any previously played sound

        // Get the resource ID of the sound file from raw resources
        val resId = context.resources.getIdentifier(fileName, "raw", context.packageName)
        if (resId == 0) return  // Return if resource ID is not found

        mediaPlayer = MediaPlayer.create(context, resId).apply {
            setOnCompletionListener {
                release()  // Release media player when playback completes
            }
            start()  // Start playback
        }
    }

    // Release the media player to free resources
    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
