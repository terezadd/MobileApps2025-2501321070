package com.terezadimitrova.eventsbuilder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        val nameInput = findViewById<EditText>(R.id.etEventName)
        val dateInput = findViewById<EditText>(R.id.etEventDate)
        val saveButton = findViewById<Button>(R.id.btnSave)

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val date = dateInput.text.toString()

            // TODO
            finish()
        }
    }
}
