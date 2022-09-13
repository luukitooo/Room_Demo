package com.example.notesapp.domain.usecase

import com.example.notesapp.data.local.dto.Note
import com.example.notesapp.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.addNote(note)
    }

}