package com.terezadimitrova.eventsbuilder

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class EventViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: EventRepository

    init {
        val dao = EventDatabase.getDatabase(application).eventDao()
        repository = EventRepository(dao)
    }

    fun getAllEvents(): List<Event> = repository.getAllEvents()
    fun insertEvent(event: Event) = repository.insertEvent(event)
    fun updateEvent(event: Event) = repository.updateEvent(event)
    fun deleteEvent(event: Event) = repository.deleteEvent(event)
}