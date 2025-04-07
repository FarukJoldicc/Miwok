package com.faruk.miwok.colors.model

import com.faruk.miwok.data.Word
import com.faruk.miwok.data.WordData

class ColorsRepository {
    fun getWords(): List<Word> {
        return WordData.getWordsByCategory("Colors")
    }
}
