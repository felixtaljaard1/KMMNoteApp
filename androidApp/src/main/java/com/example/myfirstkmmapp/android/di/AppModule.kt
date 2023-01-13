package com.example.myfirstkmmapp.android.di

import android.app.Application
import com.example.myfirstkmmapp.data.local.DatabaseDriverFactory
import com.example.myfirstkmmapp.data.note.SqlDelightNoteDataSource
import com.example.myfirstkmmapp.database.NoteDatabase
import com.example.myfirstkmmapp.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }
}