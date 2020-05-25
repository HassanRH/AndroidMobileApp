package com.example.hassan.mandatoryopgave

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DeleteReservationButton.setOnClickListener {
            val intent = Intent(this, DeleteReservationActivity::class.java)
            startActivity(intent)
        }

        AddReservationButton.setOnClickListener {
            val intent = Intent(this, AddReservationActivity::class.java)
            startActivity(intent)

        }
        SeeReservationButton.setOnClickListener {
            val intent = Intent(this, SeeReservatonActivity::class.java)
            startActivity(intent)

        }
    }
}
