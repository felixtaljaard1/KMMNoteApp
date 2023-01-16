package com.example.myfirstkmmapp.data.local.di

import com.example.myfirstkmmapp.data.local.DatabaseDriverFactory
import com.example.myfirstkmmapp.data.note.SqlDelightNoteDataSource
import com.example.myfirstkmmapp.database.NoteDatabase
import com.example.myfirstkmmapp.domain.note.NoteDataSource

class DataBaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
     val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}