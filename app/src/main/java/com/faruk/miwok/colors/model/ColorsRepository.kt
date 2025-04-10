package com.faruk.miwok.colors.model

import android.content.Context
import com.faruk.miwok.data.MiwokDatabase
import com.faruk.miwok.data.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ColorsRepository(context: Context) {

    private val wordDao = MiwokDatabase.getDatabase(context.applicationContext).wordDao()

    // Fetch words by category "Colors"
    suspend fun getWords(): List<Word> = withContext(Dispatchers.IO) {
        wordDao.getWordsByCategory("Colors")
    }
}
