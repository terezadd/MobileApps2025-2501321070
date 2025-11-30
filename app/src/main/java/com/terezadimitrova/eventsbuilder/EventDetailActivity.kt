package com.terezadimitrova.eventsbuilder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EventDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: EventViewModel
    private var eventId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)
        viewModel = EventViewModel(application)

        eventId = intent.getIntExtra("eventId", -1)

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            val intent = Intent(this, EditEventActivity::class.java)
            intent.putExtra("eventId", eventId)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            val event = viewModel.getAllEvents().find { it.id == eventId }
            if (event != null) {
                viewModel.deleteEvent(event = event)
                finish()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadEventData()
    }

    private fun loadEventData() {
        val event = viewModel.getAllEvents().find { it.id == eventId }

        if (event != null) {
            findViewById<TextView>(R.id.tvName).text = event.name
            findViewById<TextView>(R.id.tvDate).text = "Date: ${event.date}"
            findViewById<TextView>(R.id.tvHour).text = "Time: ${event.time}"
            findViewById<TextView>(R.id.tvAddress).text = "Location: ${event.location}"
            findViewById<TextView>(R.id.tvDescription).text = "Description: ${event.description}"
        }
    }
}