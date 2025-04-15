package com.faruk.miwok.di

import android.content.Context
import androidx.room.Room
import com.faruk.miwok.model.data.MiwokDatabase
import com.faruk.miwok.model.data.SeedDatabaseCallback
import com.faruk.miwok.model.data.WordDao
import com.faruk.miwok.model.repository.WordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MiwokDatabase {
        return Room.databaseBuilder(
            context,
            MiwokDatabase::class.java,
            "miwok_database"
        ).addCallback(SeedDatabaseCallback(context))
            .build()
    }

    @Provides
    fun provideWordDao(database: MiwokDatabase): WordDao {
        return database.wordDao()
    }

    @Provides
    fun provideWordRepository(wordDao: WordDao): WordRepository {
        return WordRepository(wordDao)
    }
}
