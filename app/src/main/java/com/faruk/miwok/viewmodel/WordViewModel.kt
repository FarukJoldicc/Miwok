package com.faruk.miwok.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faruk.miwok.model.data.Word
import com.faruk.miwok.model.repository.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
@HiltViewModel
class WordViewModel @Inject constructor(
    private val repository: WordRepository
) : ViewModel() {

    private val _category = MutableStateFlow("Numbers")
    val category: StateFlow<String> get() = _category

    val words: StateFlow<List<Word>> = _category
        .flatMapLatest { selectedCategory ->
            repository.getWordsByCategory(selectedCategory)
        }
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun setCategory(category: String) {
        _category.value = category
    }
}
