package com.faruk.miwok.phrases.presenter

import com.faruk.miwok.data.Word

interface PhrasesContract {
    interface View {
        fun showWords(words: List<Word>)
    }

    interface Presenter {
        fun loadWords()
        fun onDestroy()
    }
}
