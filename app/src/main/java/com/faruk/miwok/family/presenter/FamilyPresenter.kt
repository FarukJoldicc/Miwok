package com.faruk.miwok.family.presenter

import com.faruk.miwok.family.model.FamilyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FamilyPresenter(
    private var view: FamilyContract.View?,
    private val repository: FamilyRepository
) : FamilyContract.Presenter {

    private val scope = CoroutineScope(Dispatchers.Main + Job())

    override fun loadWords() {
        scope.launch {
            val words = repository.getWords()
            view?.showWords(words)
        }
    }

    override fun onDestroy() {
        view = null
    }
}
