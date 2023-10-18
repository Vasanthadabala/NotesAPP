package com.example.notesapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.feature_note.domain.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDataBase:RoomDatabase(){
    abstract val noteDao:NoteDao
    //connecting dao interface to varaible so we can access and perform operations menu items.
}