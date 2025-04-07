package com.faruk.miwok.phrases.model

import com.faruk.miwok.data.Word
import com.faruk.miwok.data.WordData

class PhrasesRepository {
    fun getWords(): List<Word> {
        return WordData.getWordsByCategory("Phrases")
    }
}
