package com.example.notesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.data.local.dto.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

}