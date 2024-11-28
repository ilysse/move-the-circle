package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paint: Paint = Paint()
    private var circleRadius: Float = 100f
    private var circleX: Float = 0f
    private var circleY: Float = 0f
    private var screenWidth: Float = 0f
    private var screenHeight: Float = 0f

    init {
        paint.color = Color.BLUE
        paint.isAntiAlias = true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        // Update screen dimensions on size change
        screenWidth = w.toFloat()
        screenHeight = h.toFloat()

        // Set initial position in the center of the screen
        circleX = screenWidth / 2
        circleY = screenHeight / 2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw the circle
        canvas.drawCircle(circleX, circleY, circleRadius, paint)
    }

    // Function to move the circle
    fun moveCircle(dx: Float, dy: Float) {
        circleX += dx
        circleY += dy

        // Ensure the circle stays within screen boundaries
        if (circleX - circleRadius < 0) {
            circleX = circleRadius
        } else if (circleX + circleRadius > screenWidth) {
            circleX = screenWidth - circleRadius
        }

        if (circleY - circleRadius < 0) {
            circleY = circleRadius
        } else if (circleY + circleRadius > screenHeight) {
            circleY = screenHeight - circleRadius
        }

        invalidate() // Redraw the view with updated position
    }
}
