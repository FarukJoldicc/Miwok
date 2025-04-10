package com.faruk.miwok.family.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.faruk.miwok.family.model.FamilyRepository
import kotlinx.coroutines.launch

class FamilyPresenter(
    private var view: FamilyContract.View?,
    private val repository: FamilyRepository,
    private val lifecycleOwner: LifecycleOwner
) : FamilyContract.Presenter {

    override fun loadWords() {
        lifecycleOwner.lifecycleScope.launch {
            val words = repository.getWords()
            view?.showWords(words)
        }
    }

    override fun onDestroy() {
        view = null
    }
}
