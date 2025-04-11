package com.faruk.miwok.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.faruk.miwok.data.Word
import com.faruk.miwok.model.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = WordRepository(application)

    private val _category = MutableLiveData<String>()
    private val _words = MutableLiveData<List<Word>>()
    val words: LiveData<List<Word>> get() = _words

    fun setCategory(category: String) {
        _category.value = category
        loadWords()
    }

    private fun loadWords() {
        _category.value?.let { category ->
            viewModelScope.launch {
                val result = repository.getWordsByCategory(category)
                _words.postValue(result)
            }
        }
    }
}
