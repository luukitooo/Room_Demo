package com.example.notesapp.domain.usecase

import com.example.notesapp.data.local.dto.Note
import com.example.notesapp.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(): List<Note> {
        return repository.getAllNotes()
    }

}