package com.faruk.miwok.model.repository

import android.content.Context
import com.faruk.miwok.model.data.Word
import com.faruk.miwok.model.data.MiwokDatabase
import kotlinx.coroutines.flow.Flow

class WordRepository(context: Context) {

    private val wordDao = MiwokDatabase.getDatabase(context).wordDao()

    fun getWordsByCategory(category: String): Flow<List<Word>> {
        return wordDao.getWordsByCategory(category)
    }
}
