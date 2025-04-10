package com.faruk.miwok.colors.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.faruk.miwok.colors.model.ColorsRepository
import kotlinx.coroutines.launch

class ColorsPresenter(
    private var view: ColorsContract.View?,
    private val repository: ColorsRepository,
    private val lifecycleOwner: LifecycleOwner
) : ColorsContract.Presenter {

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
