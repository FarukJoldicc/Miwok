package com.faruk.miwok.model.repository

import com.faruk.miwok.model.data.Word
import com.faruk.miwok.model.data.WordDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordRepository @Inject constructor(
    private val wordDao: WordDao
) {
    fun getWordsByCategory(category: String): Flow<List<Word>> {
        return wordDao.getWordsByCategory(category)
    }
}
