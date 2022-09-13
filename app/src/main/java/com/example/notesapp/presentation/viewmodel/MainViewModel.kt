package com.example.notesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.notesapp.data.local.dto.Note
import com.example.notesapp.domain.repository.NoteRepository
import com.example.notesapp.domain.usecase.AddNoteUseCase
import com.example.notesapp.domain.usecase.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase
) : ViewModel() {

    private val _notesFlow = MutableSharedFlow<List<Note>>()
    val notesFlow get() = _notesFlow.asSharedFlow()

    suspend fun getAllNotes() {
        _notesFlow.emit(getAllNotesUseCase())
    }

    suspend fun addNote(note: Note) {
        addNoteUseCase(note)
    }

}