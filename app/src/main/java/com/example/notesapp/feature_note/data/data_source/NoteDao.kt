package com.example.notesapp.feature_note.data.data_source

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notesapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getNotesFlow(): Flow<List<Note>>
    // returns a Flow,
    // which is useful for working with data asynchronously in non-UI parts of your application.

    @Query("SELECT * FROM note")
    fun getNotesLiveData(): LiveData<List<Note>>
    //returns LiveData directly from the Room query,
    //suitable for observing data changes in Android UI components.

    @Query("SELECT * FROM note")
    fun getNotesLiveDataUsingBuilder(): LiveData<List<Note>> {
        return getNotesFlow().asLiveData()
    }
    // retrieves data as a LiveData using the LiveData builder (asLiveData()),
    // which allows you to combine the benefits of Flow with LiveData.

    @Query("SELECT * FROM note Where id = :id")
    suspend fun getNoteById(id:Int):Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    @Delete
    suspend fun deleteNote(note:Note)
}