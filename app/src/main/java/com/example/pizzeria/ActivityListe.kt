package com.example.pizzeria

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ActivityListe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_liste)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.liste)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Pizzas table
        val pizzas = arrayOf(
            arrayOf(
                "Margherita",
                "95 DH",
                R.drawable.ic_margherita,
                "A timeless classic featuring a thin, crispy crust topped with fresh tomato sauce, creamy mozzarella fior di latte, fragrant basil leaves, and a drizzle of extra virgin olive oil.",
                "Ingredients : \n - Fresh Mozzarella \n - San Marzano Tomatoes \n - Fresh Basil \n - Extra Virgin Olive Oil"
            ),
            arrayOf(
                "Pepperoni",
                "100 DH",
                R.drawable.ic_pepperoni,
                "Our fan favorite is loaded with spicy, hand-sliced pepperoni curled to perfection, melting mozzarella, and our signature zesty marinara sauce."
            ),
            arrayOf(
                "BBQ Chicken",
                "110 DH", R.drawable.ic_bbq_chicken,
                "A smoky delight topped with grilled chicken breast, tangy BBQ sauce, red onions, and fresh cilantro, all layered over a blend of mozzarella and smoked gouda."
            ),
            arrayOf(
                "Meat Lovers",
                "120 DH", R.drawable.ic_meat_lovers,
                "The ultimate protein feast packed with savory ground beef, crispy bacon, spicy pepperoni, and Italian sausage for a bold and hearty flavor profile."
            ),
            arrayOf(
                "White Pizza",
                "105 DH", R.drawable.ic_white_pizza,
                "A sophisticated garlic-herb oil base topped with a creamy blend of ricotta, parmesan, and mozzarella, finished with a touch of cracked black pepper."
            ),
            arrayOf(
                "Supreme",
                "115 DH", R.drawable.ic_supreme,
                "The best of everything: loaded with pepperoni, sausage, green bell peppers, red onions, black olives, and earthy mushrooms on a classic red sauce."
            ),
            arrayOf(
                "Chicken Alfredo",
                "120 DH", R.drawable.ic_chicken_alfredo,
                "Rich and indulgent, featuring tender grilled chicken and fresh spinach on a bed of velvety white Alfredo sauce with melted mozzarella."
            ),
            arrayOf(
                "New York Style",
                "130 DH",
                R.drawable.ic_ny_style,
                "Authentic wide, foldable slices with a hand-tossed crust, heavy on the mozzarella and a perfectly balanced tomato sauce for that classic city vibe."
            ),
            arrayOf(
                "Sicilian",
                "115 DH",
                R.drawable.ic_sicilian,
                "A thick, pillowy square-cut crust that is crunchy on the bottom, airy in the middle, and smothered in robust tomato sauce and aged provolone."
            ),
            arrayOf(
                "Mushroom",
                "100 DH",
                R.drawable.ic_mushroom,
                "An earthy vegetarian treat featuring a mix of roasted button and cremini mushrooms, topped with garlic, thyme, and a hint of truffle oil."
            )
        )

        val liste = findViewById<ListView>(R.id.listview)

        liste.adapter = object : BaseAdapter() {
            override fun getCount() = pizzas.size
            override fun getItem(position: Int) = pizzas[position]
            override fun getItemId(position: Int) = position.toLong()
            override fun getView(position: Int, view: View?, parent: ViewGroup?): View? {
                val itemView = view ?: layoutInflater.inflate(R.layout.activity_liste_items, parent, false)
                val infos = pizzas[position]
                val nom = infos[0] as String
                val price = infos[1] as String
                val image = infos[2] as Int

                itemView.findViewById<ImageView>(R.id.pizza_picture).setImageResource(image)
                itemView.findViewById<TextView>(R.id.pizza_name).text = nom
                itemView.findViewById<TextView>(R.id.pizza_price).text = price

                return itemView
            }
        }


        liste.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, PizzaDetailActivity::class.java)
            val infos = pizzas[position]
            intent.putExtra("pizza_name", infos[0] as String)
            intent.putExtra("pizza_image", infos[2] as Int)
            intent.putExtra("pizza_price", infos[1] as String)
            intent.putExtra("pizza_description", infos[3] as String)
            startActivity(intent)
        }



    }
}