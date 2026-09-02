package com.example.timedate_picker

import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity(){
    private var selectedYear:Int = 0
    private var selectedMonth: Int = 0
    private var selectedDay:Int = 0
    private var selectedHour: Int = 0
    private var selectedMinute:Int = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calenderView = findViewById<CalendarView>(R.id.calender)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        val calenderTitle = findViewById<TextView>(R.id.calender_name)
        val timeTitle = findViewById<TextView>(R.id.time_name)

        val currentCalender = Calendar.getInstance()
        selectedYear = currentCalender.get(Calendar.YEAR)
        selectedMonth = currentCalender.get(Calendar.MONTH)
        selectedDay = currentCalender.get(Calendar.DAY_OF_MONTH)
        selectedHour = currentCalender.get(Calendar.HOUR_OF_DAY)
        selectedMinute = currentCalender.get(Calendar.MINUTE)

        calenderView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedYear = year
            selectedMonth = month
            selectedMinute = dayOfMonth
            showToast("Selected Date: $selectedDay/${selectedMonth + 1}/$selectedYear")
        }

        timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
            selectedHour = hourOfDay
            selectedMinute = minute

            showToast("Selected Time: String.format(\"%2d:%2d\", selectedHour, selectedMinute)")
        }
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}