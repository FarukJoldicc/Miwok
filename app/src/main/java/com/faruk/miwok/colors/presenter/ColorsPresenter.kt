package com.faruk.miwok.colors.presenter

import com.faruk.miwok.colors.model.ColorsRepository

class ColorsPresenter(
    private var view: ColorsContract.View?,
    private val repository: ColorsRepository = ColorsRepository()
) : ColorsContract.Presenter {

    override fun loadWords() {
        val words = repository.getWords()
        view?.showWords(words)
    }

    override fun onDestroy() {
        view = null
    }
}
