package com.faruk.miwok.numbers.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.faruk.miwok.numbers.model.NumbersRepository
import kotlinx.coroutines.launch

class NumbersPresenter(
    private var view: NumbersContract.View?,
    private val repository: NumbersRepository,
    private val lifecycleOwner: LifecycleOwner
) : NumbersContract.Presenter {

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
