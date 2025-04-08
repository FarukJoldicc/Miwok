package com.faruk.miwok.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.faruk.miwok.data.Word

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class MiwokDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: MiwokDatabase? = null

        fun getDatabase(context: Context): MiwokDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MiwokDatabase::class.java,
                    "miwok_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
