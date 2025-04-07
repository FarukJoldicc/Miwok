package com.faruk.miwok.family.presenter

import com.faruk.miwok.data.Word

interface FamilyContract {
    interface View {
        fun showWords(words: List<Word>)
    }

    interface Presenter {
        fun loadWords()
        fun onDestroy()
    }
}
