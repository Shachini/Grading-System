package com.myapp.gradingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var mark1: EditText
    private lateinit var mark2: EditText
    private lateinit var mark3: EditText
    private lateinit var total: EditText
    private lateinit var average: EditText
    private lateinit var grade: EditText
    private lateinit var btn1: Button
    private lateinit var btn2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.stname) as EditText
        mark1 = findViewById(R.id.marks1) as EditText
        mark2 = findViewById(R.id.marks2) as EditText
        mark3 = findViewById(R.id.marks3) as EditText
        total = findViewById(R.id.total) as EditText
        average = findViewById(R.id.avg) as EditText
        grade = findViewById(R.id.grade) as EditText

        btn1 = findViewById(R.id.btn1) as Button
        btn2 = findViewById(R.id.btn2) as Button

        btn1.setOnClickListener {
            stmarks()
        }

        btn2.setOnClickListener {
            clear()
        }
    }
    private fun stmarks(){
        val value1 = mark1.text.toString().toInt()
        val value2 = mark2.text.toString().toInt()
        val value3 = mark3.text.toString().toInt()

        val tot = value1+value2+value3
        total.setText(tot.toString())

        val avg = tot/3.0
        average.setText(avg.toString())

        when {
            avg > 75 -> grade.setText("A")
            avg > 65 -> grade.setText("B")
            avg > 55 -> grade.setText("C")
            avg > 35 -> grade.setText("S")
            else -> grade.setText("Fail")
        }

    }
    private fun clear(){
        name.text.clear()
        mark1.text.clear()
        mark2.text.clear()
        mark3.text.clear()
        total.text.clear()
        average.text.clear()
        grade.text.clear()
        name.requestFocus()

    }

}