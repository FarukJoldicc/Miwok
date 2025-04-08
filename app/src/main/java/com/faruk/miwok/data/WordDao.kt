package com.faruk.miwok.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * FROM words WHERE category = :category")
    suspend fun getWordsByCategory(category: String): List<Word>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(words: List<Word>)
}
