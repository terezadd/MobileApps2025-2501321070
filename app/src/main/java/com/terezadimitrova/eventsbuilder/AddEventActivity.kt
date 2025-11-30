package com.terezadimitrova.eventsbuilder

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddEventActivity : AppCompatActivity() {

    private lateinit var viewModel: EventViewModel
    private val selectedDateTime = Calendar.getInstance()

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

        dateInput.keyListener = null
        timeInput.keyListener = null

        dateInput.setOnClickListener {
            showDatePicker(dateInput)
        }

        timeInput.setOnClickListener {
            showTimePicker(timeInput)
        }

        saveButton.setOnClickListener {
            val newEvent = Event(
                name = nameInput.text.toString(),
                date = dateInput.text.toString(),
                time = timeInput.text.toString(),
                location = locationInput.text.toString(),
                description = descInput.text.toString()
            )

            viewModel.insertEvent(newEvent)
            finish()
        }
    }

    private fun showDatePicker(dateInput: EditText) {
        val now = Calendar.getInstance()

        DatePickerDialog(
            this,
            { _, year, month, day ->
                selectedDateTime.set(Calendar.YEAR, year)
                selectedDateTime.set(Calendar.MONTH, month)
                selectedDateTime.set(Calendar.DAY_OF_MONTH, day)

                val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                dateInput.setText(sdf.format(selectedDateTime.time))
            },
            now.get(Calendar.YEAR),
            now.get(Calendar.MONTH),
            now.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun showTimePicker(timeInput: EditText) {
        val now = Calendar.getInstance()

        TimePickerDialog(
            this,
            { _, hour, minute ->
                selectedDateTime.set(Calendar.HOUR_OF_DAY, hour)
                selectedDateTime.set(Calendar.MINUTE, minute)

                val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
                timeInput.setText(sdf.format(selectedDateTime.time))
            },
            now.get(Calendar.HOUR_OF_DAY),
            now.get(Calendar.MINUTE),
            true
        ).show()
    }
}
