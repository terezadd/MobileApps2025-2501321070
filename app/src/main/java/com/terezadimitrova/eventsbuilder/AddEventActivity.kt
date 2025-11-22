package com.terezadimitrova.eventsbuilder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        val nameInput = findViewById<EditText>(R.id.etName)
        val dateInput = findViewById<EditText>(R.id.etDate)
        val hourInput = findViewById<EditText>(R.id.etHour)
        val addressInput = findViewById<EditText>(R.id.etAddress)
        val descInput = findViewById<EditText>(R.id.etDescription)

        val saveButton = findViewById<Button>(R.id.btnSave)

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val date = dateInput.text.toString()
            val hour = hourInput.text.toString()
            val address = addressInput.text.toString()
            val description = descInput.text.toString()

            // TODO
            finish()
        }
    }
}
