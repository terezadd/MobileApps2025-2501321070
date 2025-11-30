package com.terezadimitrova.eventsbuilder

class EventRepository(private val dao: EventDao) {
    fun getAllEvents() = dao.getAll()
    fun insertEvent(event: Event) = dao.insert(event)
    fun updateEvent(event: Event) = dao.update(event)
    fun deleteEvent(event: Event) = dao.delete(event)
}