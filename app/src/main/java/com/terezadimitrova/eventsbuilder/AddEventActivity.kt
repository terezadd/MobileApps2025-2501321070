package com.terezadimitrova.eventsbuilder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddEventActivity : AppCompatActivity() {
    private lateinit var viewModel: EventViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        viewModel = EventViewModel(application)

        val nameInput = findViewById<EditText>(R.id.etName)
        val dateInput = findViewById<EditText>(R.id.etDate)
        val timeInput = findViewById<EditText>(R.id.etTime)
        val locationInput = findViewById<EditText>(R.id.etLocation)
        val descInput = findViewById<EditText>(R.id.etDescription)

        val saveButton = findViewById<Button>(R.id.btnSave)

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val date = dateInput.text.toString()
            val time = timeInput.text.toString()
            val location = locationInput.text.toString()
            val description = descInput.text.toString()

//            if (name.isEmpty() || date.isEmpty()) {
//                Toast.makeText(this, "Name and Date are required", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }

            val newEvent = Event(
                name = name,
                date = date,
                time = time,
                location = location,
                description = description
            )

            viewModel.insertEvent(newEvent)

            finish()
        }
    }
}
