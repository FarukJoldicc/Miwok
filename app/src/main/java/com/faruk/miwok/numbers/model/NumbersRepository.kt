package com.faruk.miwok.numbers.model

import com.faruk.miwok.data.Word
import com.faruk.miwok.data.WordData

class NumbersRepository {
    fun getWords(): List<Word> {
        return WordData.getWordsByCategory("Numbers")
    }
}
