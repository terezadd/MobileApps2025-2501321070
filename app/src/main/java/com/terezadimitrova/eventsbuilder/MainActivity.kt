package com.terezadimitrova.eventsbuilder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.btnAddEvent)

        addButton.setOnClickListener {
            val intent = Intent(this, AddEventActivity::class.java)
            startActivity(intent)
        }
    }
}
