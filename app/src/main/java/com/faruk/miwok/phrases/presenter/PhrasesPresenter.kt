package com.faruk.miwok.phrases.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.faruk.miwok.phrases.model.PhrasesRepository
import kotlinx.coroutines.launch

class PhrasesPresenter(
    private var view: PhrasesContract.View?,
    private val repository: PhrasesRepository,
    private val lifecycleOwner: LifecycleOwner
) : PhrasesContract.Presenter {

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
