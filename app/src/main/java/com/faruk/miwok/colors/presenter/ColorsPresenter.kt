package com.faruk.miwok.colors.presenter

import androidx.lifecycle.viewModelScope
import com.faruk.miwok.colors.model.ColorsRepository
import kotlinx.coroutines.launch

class ColorsPresenter(
    private var view: ColorsContract.View?,
    private val repository: ColorsRepository
) : ColorsContract.Presenter {

    override fun loadWords() {
        // Use coroutines to load data in the background
        view?.let {
            // launch the coroutine
            it.lifecycleScope.launch {
                val words = repository.getWords()
                view?.showWords(words)
            }
        }
    }

    override fun onDestroy() {
        view = null
    }
}
