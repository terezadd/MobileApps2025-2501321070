package com.terezadimitrova.eventsbuilder

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EventDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        val eventId = intent.getIntExtra("eventId", -1)

        val db = EventDatabase.getDatabase(this)
        val event = db.eventDao().getAll().find { it.id == eventId }

        if (event != null) {
            findViewById<TextView>(R.id.tvName).text = event.name
            findViewById<TextView>(R.id.tvDate).text = "Date: ${event.date}"
            findViewById<TextView>(R.id.tvHour).text = "Hour: ${event.time}"
            findViewById<TextView>(R.id.tvAddress).text = "Address: ${event.location}"
            findViewById<TextView>(R.id.tvDescription).text = "Description: ${event.description}"
        }
    }
}
