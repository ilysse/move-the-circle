package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var circleView: CircleView
    private val moveDistance = 50f // Move the circle by 50 pixels each time

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get reference to the CircleView and buttons
        circleView = findViewById(R.id.circleView)
        val buttonUp = findViewById<Button>(R.id.buttonUp)
        val buttonLeft = findViewById<Button>(R.id.buttonLeft)
        val buttonRight = findViewById<Button>(R.id.buttonRight)
        val buttonDown = findViewById<Button>(R.id.buttonDown)

        // Set button actions to move the circle
        buttonUp.setOnClickListener { circleView.moveCircle(0f, -moveDistance) }
        buttonLeft.setOnClickListener { circleView.moveCircle(-moveDistance, 0f) }
        buttonRight.setOnClickListener { circleView.moveCircle(moveDistance, 0f) }
        buttonDown.setOnClickListener { circleView.moveCircle(0f, moveDistance) }
    }
}
