package com.example.pizzeria

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_options)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.options)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //
        val pizza_option = findViewById<LinearLayout>(R.id.pizza_option)
        pizza_option.setOnClickListener {
            intent = Intent(this, ActivityListe::class.java)
            startActivity(intent)
        }

        //
        val sandwich_option = findViewById<LinearLayout>(R.id.sandwich_option)
        sandwich_option.setOnClickListener {
            intent = Intent(this, ActivityListe1::class.java)
            startActivity(intent)
        }


    }
}