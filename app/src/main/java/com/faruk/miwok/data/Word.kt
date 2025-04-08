package com.faruk.miwok.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(
    val defaultTranslation: String,
    val miwokTranslation: String,
    val imageResourceId: Int? = null,
    val category: String,
    val soundFileName: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
