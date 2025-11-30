package com.terezadimitrova.eventsbuilder

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface EventDao {
    @Insert fun insert(event: Event)
    @Update fun update(event: Event)
    @Delete fun delete(event: Event)

    @Query("SELECT * FROM events") fun getAll(): List<Event>
}