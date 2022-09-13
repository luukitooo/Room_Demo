package com.example.notesapp.di

import android.content.Context
import androidx.room.Room
import com.example.notesapp.data.local.NoteDatabase
import com.example.notesapp.data.repository.NoteRepositoryImpl
import com.example.notesapp.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "NotesDB"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepositoryImpl(database: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(database)
    }

}