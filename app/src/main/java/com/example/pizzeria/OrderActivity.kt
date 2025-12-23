package com.example.pizzeria

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.order_view)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val pizzaName = intent.getStringExtra("pizza_name")
        val pizzaImage = intent.getIntExtra("pizza_image", 0)
        val pizzaPrice = intent.getStringExtra("pizza_price")

        findViewById<ImageView>(R.id.pizza_picture).setImageResource(pizzaImage)
        findViewById<TextView>(R.id.pizza_name).text = pizzaName
        findViewById<TextView>(R.id.pizza_price).text = pizzaPrice


        //
        val btn4 = findViewById<MaterialButton>(R.id.btn4)
        btn4.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Order Confirmation")
                .setMessage(" Your order has been confirmed ! \n Our Delivery will contact you soon.")
                .setPositiveButton("OK", null)
                .show()
        }


    }
}