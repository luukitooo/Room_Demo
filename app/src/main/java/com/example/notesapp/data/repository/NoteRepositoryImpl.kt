package com.example.notesapp.data.repository

import com.example.notesapp.data.local.NoteDatabase
import com.example.notesapp.data.local.dto.Note
import com.example.notesapp.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val database: NoteDatabase
) : NoteRepository {

    override suspend fun getAllNotes(): List<Note> {
        return database.getNoteDao().getAllNotes()
    }

    override suspend fun addNote(note: Note) {
        database.getNoteDao().addNote(note)
    }

}