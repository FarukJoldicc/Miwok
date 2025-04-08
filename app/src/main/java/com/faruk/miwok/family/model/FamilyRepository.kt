package com.faruk.miwok.family.model

import android.content.Context
import com.faruk.miwok.data.MiwokDatabase
import com.faruk.miwok.data.Word
import com.faruk.miwok.data.WordData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FamilyRepository(context: Context) {

    private val wordDao = MiwokDatabase.getDatabase(context).wordDao()

    suspend fun getWords(): List<Word> = withContext(Dispatchers.IO) {
        val words = wordDao.getWordsByCategory("Family")

        if (words.isEmpty()) {
            val initialWords = WordData.getWordsByCategory("Family")
            wordDao.insertAll(initialWords)
            return@withContext initialWords
        }

        return@withContext words
    }
}
