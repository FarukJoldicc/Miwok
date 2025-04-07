package com.faruk.miwok.data

data class Word constructor(
    val defaultTranslation: String,
    val miwokTranslation: String,
    val imageResourceId: Int? = null,
    val category: String,
    val soundFileName: String
)