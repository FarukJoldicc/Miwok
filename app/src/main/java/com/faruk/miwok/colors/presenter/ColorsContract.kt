package com.faruk.miwok.colors.presenter

import com.faruk.miwok.data.Word

interface ColorsContract {
    interface View {
        fun showWords(words: List<Word>)
    }

    interface Presenter {
        fun loadWords()
        fun onDestroy()
    }
}
