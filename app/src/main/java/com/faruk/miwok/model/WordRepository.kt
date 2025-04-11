package com.faruk.miwok.model

import android.content.Context
import com.faruk.miwok.data.MiwokDatabase
import com.faruk.miwok.data.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WordRepository(context: Context) {
    private val wordDao = MiwokDatabase.getDatabase(context).wordDao()

    suspend fun getWordsByCategory(category: String): List<Word> = withContext(Dispatchers.IO) {
        wordDao.getWordsByCategory(category)
    }
}
