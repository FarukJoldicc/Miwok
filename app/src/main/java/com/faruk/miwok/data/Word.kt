package com.faruk.miwok.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "words")
data class Word(
    @ColumnInfo(name = "default_translation") val defaultTranslation: String,
    @ColumnInfo(name = "miwok_translation") val miwokTranslation: String,
    @ColumnInfo(name = "image_resource_id") val imageResourceId: Int = 0,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "sound_file_name") val soundFileName: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
