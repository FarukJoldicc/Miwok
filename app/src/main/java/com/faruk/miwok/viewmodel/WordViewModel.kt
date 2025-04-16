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

    interface ViewDelegate {
        fun getColorFromResId(resId: Int): Int
    }

    private val _category = MutableStateFlow("")
    val category: StateFlow<String> get() = _category

    private var categoryColorResId: Int = 0
    private var viewDelegate: ViewDelegate? = null

    private val _categoryColor = MutableStateFlow(0)
    val categoryColor: StateFlow<Int> get() = _categoryColor

    fun setArguments(category: String, colorResId: Int) {
        _category.value = category
        categoryColorResId = colorResId
    }

    fun setViewDelegate(delegate: ViewDelegate) {
        viewDelegate = delegate
        _categoryColor.value = viewDelegate?.getColorFromResId(categoryColorResId) ?: 0
    }

    val words: StateFlow<List<Word>> = _category
        .flatMapLatest { selectedCategory ->
            repository.getWordsByCategory(selectedCategory)
        }
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    override fun onCleared() {
        super.onCleared()
        viewDelegate = null
    }
}
