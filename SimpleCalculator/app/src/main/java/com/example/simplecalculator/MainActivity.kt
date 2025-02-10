package com.example.simplecalculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.simplecalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var e1: EditText
    private lateinit var e2: EditText
    private lateinit var t1: TextView
    private var num1: Int = 0
    private var num2: Int = 0

    private fun getNumbers(): Boolean {

        // defining the edit text 1 to e1
        e1 = findViewById(R.id.num1)

        // defining the edit text 2 to e2
        e2 = findViewById(R.id.num2)

        // defining the text view to t1
        t1 = findViewById(R.id.result)

        // taking input from text box 1
        val s1 = e1.text.toString()

        // taking input from text box 2
        val s2 = e2.text.toString()

        if (s1 == "Please enter value 1" && s2.isEmpty()) {
            val result = "Please enter value 2"
            e2.setText(result)
            return false
        }
        if (s1.isEmpty() && s2 == "Please enter value 2") {
            val result = "Please enter value 1"
            e1.setText(result)
            return false
        }
        if (s1 == "Please enter value 1" || s2 == "Please enter value 2") {
            return false
        }

        if ((s1.isNotEmpty() && s2.isEmpty()) || (s1.isNotEmpty() && s2 == "")) {
            val result = "Please enter value 2"
            e2.setText(result)
            return false
        }
        if ((s1.isEmpty() && s2.isNotEmpty()) || (s1 == "" && s2.isNotEmpty())) {
            val result = "Please enter value 1"
            e1.setText(result)
            return false
        }
        if ((s1.isEmpty() && s2.isEmpty()) || (s1 == "" && s2 == "")) {
            val result1 = "Please enter value 1"
            e1.setText(result1)
            val result2 = "Please enter value 2"
            e2.setText(result2)
            return false
        } else {
            // converting string to int.
            num1 = s1.toInt()

            // converting string to int.
            num2 = s2.toInt()
        }

        return true
    }

    fun doSum(view: View) {
        // get the input numbers
        if (getNumbers()) {
            val sum = num1 + num2
            t1.text = sum.toString()
        } else {
            t1.text = "Error Please enter Required Values"
        }
    }

    fun clearTextNum1(view: View) {
        // get the input numbers
        e1.text.clear()
    }

    fun clearTextNum2(view: View) {
        // get the input numbers
        e2.text.clear()
    }

    fun doPow(view: View) {
        // get the input numbers
        if (getNumbers()) {
            val sum = Math.pow(num1.toDouble(), num2.toDouble())
            t1.text = sum.toString()
        } else {
            t1.text = "Error Please enter Required Values"
        }
    }

    // a public method to perform subtraction
    fun doSub(view: View) {
        // get the input numbers
        if (getNumbers()) {
            val sum = num1 - num2
            t1.text = sum.toString()
        } else {
            t1.text = "Error Please enter Required Values"
        }
    }

    // a public method to perform multiplication
    fun doMul(view: View) {
        // get the input numbers
        if (getNumbers()) {
            val sum = num1 * num2
            t1.text = sum.toString()
        } else {
            t1.text = "Error Please enter Required Values"
        }
    }

    // a public method to perform Division
    fun doDiv(view: View) {
        // get the input numbers
        if (getNumbers()) {
            // displaying the text in text view assigned as t1
            val sum = num1 / (num2 * 1.0)
            t1.text = sum.toString()
        } else {
            t1.text = "Error Please enter Required Values"
        }
    }

    // a public method to perform modulus function
    fun doMod(view: View) {
        // get the input numbers
        if (getNumbers()) {
            val sum = num1 % num2
            t1.text = sum.toString()
        } else {
            t1.text = "Error Please enter Required Values"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        e1 = findViewById(R.id.num1)
        // defining the edit text 2 to e2
        e2 = findViewById(R.id.num2)
    }
}