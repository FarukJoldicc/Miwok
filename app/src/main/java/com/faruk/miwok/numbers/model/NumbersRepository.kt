package com.faruk.miwok.numbers.model

import android.content.Context
import com.faruk.miwok.data.MiwokDatabase
import com.faruk.miwok.data.Word

class NumbersRepository(context: Context) {

    private val wordDao = MiwokDatabase.getDatabase(context).wordDao()

    suspend fun getWords(): List<Word> {
        return wordDao.getWordsByCategory("Numbers")
    }
}
