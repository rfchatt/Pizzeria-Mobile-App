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

class PizzaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pizza_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.description_view)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pizzaName = intent.getStringExtra("pizza_name")
        val pizzaImage = intent.getIntExtra("pizza_image", 0)
        val pizzaDescription = intent.getStringExtra("pizza_description")
        val pizzaPrice = intent.getStringExtra("pizza_price")

        findViewById<ImageView>(R.id.pizza_picture).setImageResource(pizzaImage)
        findViewById<TextView>(R.id.pizza_name).text = pizzaName
        findViewById<TextView>(R.id.pizza_description).text = pizzaDescription

        val btnOrder = findViewById<MaterialButton>(R.id.btn_order)
        btnOrder.setOnClickListener {
            val orderIntent = Intent(this, OrderActivity::class.java)
            orderIntent.putExtra("pizza_name", pizzaName)
            orderIntent.putExtra("pizza_image", pizzaImage)
            orderIntent.putExtra("pizza_price", pizzaPrice)
            startActivity(orderIntent)
        }



    }
}