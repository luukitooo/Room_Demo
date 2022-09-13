package com.example.notesapp.data.local

import androidx.room.*
import com.example.notesapp.data.local.dto.Note

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM notes_table")
    suspend fun getAllNotes(): List<Note>

}