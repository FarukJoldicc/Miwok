package com.faruk.miwok.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faruk.miwok.model.data.Word
import com.faruk.miwok.model.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import android.util.Log

@HiltViewModel
class WordViewModel @Inject constructor(
    private val repository: WordRepository
) : ViewModel() {

    private val _category = MutableStateFlow("Numbers")
    val category: StateFlow<String> get() = _category

    private val _words = MutableStateFlow<List<Word>>(emptyList())
    val words: StateFlow<List<Word>> get() = _words

    init {
        collectWords()  // Initial collection of words
    }

    fun setCategory(category: String) {
        if (_category.value != category) {
            _category.value = category
            collectWords()
        }
    }

    fun collectWords() {
        viewModelScope.launch {
            repository.getWordsByCategory(_category.value)
                .collect { words ->
                    _words.value = words
                    Log.d("WordViewModel", "Words collected for category ${_category.value}: $words")
                }
        }
    }
}
