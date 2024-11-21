package com.example.myandroidapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var firstNameField: TextInputEditText
    lateinit var lastNameField: TextInputEditText
    lateinit var emailField: TextInputEditText
    lateinit var passwordField: TextInputEditText
    lateinit var signUpButton: Button
    lateinit var titleText1: TextView
    lateinit var titleText2: TextView
    lateinit var backArrow: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        firstNameField = findViewById(R.id.firstNameField)
        lastNameField = findViewById(R.id.lastNameField)
        emailField = findViewById(R.id.emailField)
        passwordField = findViewById(R.id.passwordField)
        signUpButton = findViewById(R.id.signup)
        titleText1 = findViewById(R.id.titleText)
        titleText2 = findViewById(R.id.titleText2)

        backArrow.setOnClickListener {
            onBackPressed()
        }

        signUpButton.setOnClickListener {
            val firstName = firstNameField.text.toString()
            val lastName = lastNameField.text.toString()
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this@MainActivity,"Please fill all the fields",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@MainActivity,"Welcome, $firstName !", Toast.LENGTH_SHORT).show()
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}