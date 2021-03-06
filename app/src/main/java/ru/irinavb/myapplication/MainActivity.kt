package ru.irinavb.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private val discountButton: Button
        get() = findViewById(R.id.discount_button)

    private val firstName: EditText
        get() = findViewById(R.id.first_name)

    private val lastName: EditText
        get() = findViewById(R.id.last_name)

    private val email: EditText
        get() = findViewById(R.id.email)

    private val discountCodeConfirmation: TextView
        get() = findViewById(R.id.discount_code_confirmation)

    private val discountCode: TextView
        get() = findViewById(R.id.discount_code)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        discountButton.setOnClickListener {
            val firstName = firstName.text.toString().trim()
            val lastName = lastName.text.toString().trim()
            val email = email.text.toString()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.discount_code_validation),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Log.d(TAG, "In method")
                val fullName = firstName.plus(" ").plus(lastName)

                discountCodeConfirmation.text =
                    getString(R.string.discount_code_confirmation, fullName)
                // Generates discount code
                discountCode.text = UUID.randomUUID().toString().take(8).uppercase()

                hideKeyboard()
                clearInputFields()

            }
        }
    }

    private fun clearInputFields() {
        firstName.text.clear()
        lastName.text.clear()
        email.text.clear()
    }

    private fun hideKeyboard() {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    companion object {
        private const val TAG = "Main Activity"
        private const val DISCOUNT_CONFIRMATION_MESSAGE = "DISCOUNT_CONFIRMATION_MESSAGE"
        private const val DISCOUNT_CODE = "DISCOUNT_CODE"
    }
}