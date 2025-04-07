package com.faruk.miwok.family.model

import com.faruk.miwok.data.Word
import com.faruk.miwok.data.WordData

class FamilyRepository {
    fun getWords(): List<Word> {
        return WordData.getWordsByCategory("Family")
    }
}
