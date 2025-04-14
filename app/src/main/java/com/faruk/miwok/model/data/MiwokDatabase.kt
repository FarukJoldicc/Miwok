package com.faruk.miwok.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class MiwokDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    class SeedDatabaseCallback(private val context: Context) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(Dispatchers.IO).launch {
                val database = getDatabaseInstance(context)
                database.wordDao().insertAll(WordData.getAllWords())
            }
        }

        private fun getDatabaseInstance(context: Context): MiwokDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MiwokDatabase::class.java,
                "miwok_database"
            ).build()
        }
    }
}
