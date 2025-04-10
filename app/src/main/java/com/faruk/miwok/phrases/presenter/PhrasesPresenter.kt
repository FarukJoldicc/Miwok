package com.faruk.miwok.phrases.presenter

import com.faruk.miwok.phrases.model.PhrasesRepository

class PhrasesPresenter(
    private var view: PhrasesContract.View? = null,
    private val repository: PhrasesRepository = PhrasesRepository()
) : PhrasesContract.Presenter {

    override fun loadWords() {
        val words = repository.getWords()
        view?.showWords(words)
    }

    override fun onDestroy() {
        view = null
    }
}
