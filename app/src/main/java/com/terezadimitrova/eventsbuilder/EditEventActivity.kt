package com.terezadimitrova.eventsbuilder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditEventActivity : AppCompatActivity() {

    private lateinit var viewModel: EventViewModel
    private var eventId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_event)

        viewModel = EventViewModel(application)

        eventId = intent.getIntExtra("eventId", -1)

        val nameInput = findViewById<EditText>(R.id.etName)
        val dateInput = findViewById<EditText>(R.id.etDate)
        val timeInput = findViewById<EditText>(R.id.etTime)
        val locationInput = findViewById<EditText>(R.id.etLocation)
        val descInput = findViewById<EditText>(R.id.etDescription)

        val saveButton = findViewById<Button>(R.id.btnSaveChanges)

        val event = viewModel.getAllEvents().find { it.id == eventId }

        if (event != null) {
            nameInput.setText(event.name)
            dateInput.setText(event.date)
            timeInput.setText(event.time)
            locationInput.setText(event.location)
            descInput.setText(event.description)
        }

        saveButton.setOnClickListener {

            val updatedEvent = Event(
                id = eventId,
                name = nameInput.text.toString(),
                date = dateInput.text.toString(),
                time = timeInput.text.toString(),
                location = locationInput.text.toString(),
                description = descInput.text.toString()
            )

            viewModel.updateEvent(updatedEvent)
            finish()
        }
    }
}
