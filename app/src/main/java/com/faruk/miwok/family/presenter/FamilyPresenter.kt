package com.faruk.miwok.family.presenter

import com.faruk.miwok.family.model.FamilyRepository

class FamilyPresenter(
    private var view: FamilyContract.View? = null,
    private val repository: FamilyRepository = FamilyRepository()
) : FamilyContract.Presenter {

    override fun loadWords() {
        val words = repository.getWords()
        view?.showWords(words)
    }

    override fun onDestroy() {
        view = null
    }
}
