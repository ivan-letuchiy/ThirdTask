package com.example.thirdtask

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var resultText: TextView
    private lateinit var operationLabel: TextView
    private lateinit var btnClose: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        resultText = findViewById(R.id.resultText)
        operationLabel = findViewById(R.id.operationLabel)
        btnClose = findViewById(R.id.btnClose)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            calculate("+")
        }

        findViewById<Button>(R.id.btnSubtract).setOnClickListener {
            calculate("-")
        }

        findViewById<Button>(R.id.btnMultiply).setOnClickListener {
            calculate("*")
        }

        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            calculate("/")
        }

        btnClose.setOnClickListener {
            finish()
        }
    }

    private fun calculate(op: String) {
        val num1 = input1.text.toString().toDoubleOrNull()
        val num2 = input2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            resultText.text = "Ошибка ввода"
            return
        }

        val result = when (op) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else "Деление на 0"
            else -> "Ошибка"
        }

        operationLabel.text = op
        resultText.text = if (result is Double && result % 1 == 0.0) {
            result.toInt().toString()
        } else {
            result.toString()
        }

    }
}
