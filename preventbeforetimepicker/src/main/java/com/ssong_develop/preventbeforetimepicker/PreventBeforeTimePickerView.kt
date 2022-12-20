package com.ssong_develop.preventbeforetimepicker

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import java.util.*

class PreventBeforeTimePickerView : AppCompatActivity() {

    private lateinit var timePicker: TimePicker
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prevent_before_time_picker_view)

        timePicker = findViewById(R.id.test_time_picker)
        textView = findViewById(R.id.test)

        /** 단순히 클릭만 안되는 거라면 이 로직을 사용하는데 좀 더 색다르게 기능을 한번 만들어 봅시다 **/
        timePicker.setOnTimeChangedListener { timePicker, hourOfDay, minute ->
            val dateTime = Calendar.getInstance()
            val calendar = Calendar.getInstance()
            dateTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
            dateTime.set(Calendar.MINUTE,minute)
            if (dateTime.timeInMillis >= calendar.timeInMillis) {
                val hour = hourOfDay % 12
                textView.text = String.format("%02d: %02d %s", hour,minute, if (hourOfDay < 12) "am" else "pm")
            } else {
                Toast.makeText(this,"invalid",Toast.LENGTH_SHORT).show()
            }
        }
    }
}