package com.faruk.miwok.numbers.presenter

import com.faruk.miwok.numbers.model.NumbersRepository

class NumbersPresenter(
    private var view: NumbersContract.View?,
    private val repository: NumbersRepository = NumbersRepository()
) : NumbersContract.Presenter {

    override fun loadWords() {
        val words = repository.getWords()
        view?.showWords(words)
    }

    override fun onDestroy() {
        view = null
    }
}
