package com.faruk.miwok.model

import android.content.Context
import com.faruk.miwok.data.Word
import com.faruk.miwok.data.MiwokDatabase
import kotlinx.coroutines.flow.Flow

class WordRepository(context: Context) {

    private val wordDao = MiwokDatabase.getDatabase(context).wordDao()

    fun getWordsByCategory(category: String): Flow<List<Word>> {
        return wordDao.getWordsByCategory(category)
    }
}
