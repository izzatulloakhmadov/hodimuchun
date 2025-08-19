package com.example.hodimuchun

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hodimuchun.R
import java.text.SimpleDateFormat
import java.util.*

class MessageActivity : AppCompatActivity() {

    private lateinit var refreshIcon: ImageView
    private val refreshInterval = 5 * 60 * 1000L // 5 daqiqa
    private val handler = Handler(Looper.getMainLooper())

    private val refreshRunnable = object : Runnable {
        override fun run() {
            refreshContent()
            handler.postDelayed(this, refreshInterval)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        refreshIcon = findViewById(R.id.refreshIcon)

        refreshIcon.setOnClickListener {
            refreshContent()
        }

        handler.postDelayed(refreshRunnable, refreshInterval)

        // Dastlab bir marta ishga tushadi
        refreshContent()
    }

    private fun refreshContent() {
        // Bu yerga API chaqirishingiz yoki ma'lumotlarni yangilash kodingiz tushadi
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        Log.d("REFRESH_CHECK", "Yangilandi: $currentTime")
        Toast.makeText(this, "Ma'lumot yangilandi", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(refreshRunnable)
    }
}
