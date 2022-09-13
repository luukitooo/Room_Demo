package com.example.notesapp.domain.repository

import com.example.notesapp.data.local.dto.Note

interface NoteRepository {

    suspend fun getAllNotes(): List<Note>

    suspend fun addNote(note: Note)

}