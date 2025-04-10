package com.faruk.miwok.phrases.model

import android.content.Context
import com.faruk.miwok.data.MiwokDatabase
import com.faruk.miwok.data.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhrasesRepository(context: Context) {

    private val wordDao = MiwokDatabase.getDatabase(context).wordDao()

    suspend fun getWords(): List<Word> = withContext(Dispatchers.IO) {
        wordDao.getWordsByCategory("Phrases")
    }
}
