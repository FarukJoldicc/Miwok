package com.faruk.miwok

data class Word(
    val defaultTranslation: String,
    val miwokTranslation: String,
    val imageResourceId: Int? = null,
    val category: String // New field to store the category
)