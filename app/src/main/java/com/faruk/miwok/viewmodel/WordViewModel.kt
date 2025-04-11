package com.faruk.miwok.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.faruk.miwok.model.data.Word
import com.faruk.miwok.model.repository.WordRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = WordRepository(application)

    private val _category = MutableStateFlow("Numbers")
    val category: StateFlow<String> get() = _category

    private val _words = MutableStateFlow<List<Word>>(emptyList())
    val words: StateFlow<List<Word>> get() = _words

    init {
        collectWords()
    }

    fun setCategory(category: String) {
        _category.value = category
        collectWords()
    }

    private fun collectWords() {
        viewModelScope.launch {
            repository.getWordsByCategory(_category.value)
                .collect { words ->
                    _words.value = words
                }
        }
    }
}
