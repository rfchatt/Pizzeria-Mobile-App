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

class OrderActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.order_view1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sandwichName = intent.getStringExtra("sandwich_name")
        val sandwichImage = intent.getIntExtra("sandwich_image", 0)
        val sandwichPrice = intent.getStringExtra("sandwich_price")

        findViewById<ImageView>(R.id.sandwich_picture).setImageResource(sandwichImage)
        findViewById<TextView>(R.id.sandwich_name).text = sandwichName
        findViewById<TextView>(R.id.sandwich_price).text = sandwichPrice


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