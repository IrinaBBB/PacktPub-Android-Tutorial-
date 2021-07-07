package ru.irinavb.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import ru.irinavb.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.enterButton.setOnClickListener {
            val greetingDisplay = binding.greetingDisplay
            val firstName = binding.firstName.text?.trim()
            val lastName = binding.lastName.text?.trim()

            if (firstName?.isNotEmpty() == true && lastName?.isNotEmpty() == true) {
                val nameToDisplay = firstName.toString().plus(" ").plus(lastName)
                greetingDisplay.text = "Welcome to the app $nameToDisplay!"
            } else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
            }
        }
    }
}