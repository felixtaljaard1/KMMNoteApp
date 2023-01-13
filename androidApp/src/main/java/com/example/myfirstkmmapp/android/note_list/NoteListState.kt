package com.example.myfirstkmmapp.android.note_list

import com.example.myfirstkmmapp.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)
