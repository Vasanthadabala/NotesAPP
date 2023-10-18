package com.example.notesapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notesapp.ui.theme.BabyBlue
import com.example.notesapp.ui.theme.LightBlue
import com.example.notesapp.ui.theme.LightGreen
import com.example.notesapp.ui.theme.RedOrange
import com.example.notesapp.ui.theme.RedPink
import com.example.notesapp.ui.theme.Violet

@Entity(tableName = "note")
data class Note(
    val title:String,
    val content:String,
    val timestamp:Long,
    val color:Int,
    @PrimaryKey val id:Int? = null
)
{
    companion object{
        val noteColors  = listOf(
            RedOrange,
            LightBlue,
            LightGreen,
            Violet,
            BabyBlue,
            RedPink
        )
    }
    //Companion object can be accessible directly without creating instance of class.
}