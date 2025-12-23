package com.example.pizzeria

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class SandwichDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sandwich_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.description_view1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sandwichName = intent.getStringExtra("sandwich_name")
        val sandwichImage = intent.getIntExtra("sandwich_image", 0)
        val sandwichDescription = intent.getStringExtra("sandwich_description")
        val sandwichPrice = intent.getStringExtra("sandwich_price")

        findViewById<ImageView>(R.id.sandwich_picture).setImageResource(sandwichImage)
        findViewById<TextView>(R.id.sandwich_name).text = sandwichName
        findViewById<TextView>(R.id.sandwich_description).text = sandwichDescription

        val btnOrder = findViewById<MaterialButton>(R.id.btn_order)
        btnOrder.setOnClickListener {
            val orderIntent = Intent(this, OrderActivity1::class.java)
            orderIntent.putExtra("sandwich_name", sandwichName)
            orderIntent.putExtra("sandwich_image", sandwichImage)
            orderIntent.putExtra("sandwich_price", sandwichPrice)
            startActivity(orderIntent)
        }



    }
}