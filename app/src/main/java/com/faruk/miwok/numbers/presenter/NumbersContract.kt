package com.faruk.miwok.numbers.presenter

import com.faruk.miwok.data.Word

interface NumbersContract {
    interface View {
        fun showWords(words: List<Word>)
    }

    interface Presenter {
        fun loadWords()
        fun onDestroy()
    }
}
