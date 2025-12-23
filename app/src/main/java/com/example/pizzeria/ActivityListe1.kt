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

class ActivityListe1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_liste1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.liste1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

// Sandwiches table
        val sandwiches = arrayOf(
            arrayOf(
                "Club Sandwich",
                "85 DH",
                R.drawable.ic_club_sandwich,
                "A triple-decker classic layered with toasted bread, roasted chicken, crispy bacon, fresh lettuce, tomato, and creamy mayo. Served with a side of fries."
            ),
            arrayOf(
                "Banh-Mi Sandwich",
                "75 DH",
                R.drawable.ic_banh_mi_sandwich,
                "A fusion of flavors featuring a crusty baguette filled with savory grilled meat, pickled daikon and carrots, fresh cilantro, cucumbers, and a hint of spicy mayo."
            ),
            arrayOf(
                "Reuben Sandwich",
                "95 DH",
                R.drawable.ic_reuben_sandwich,
                "A deli favorite made with grilled rye bread, piled high with sliced corned beef, melted Swiss cheese, tangy sauerkraut, and Russian dressing."
            ),
            arrayOf(
                "Philly Cheesesteak Sandwich",
                "110 DH",
                R.drawable.ic_phily_cheesesteak_sandwich,
                "Thinly sliced sautéed ribeye beef and melted provolone cheese, packed into a soft, toasted hoagie roll with caramelized onions and bell peppers."
            ),
            arrayOf(
                "Croque Monsieur",
                "80 DH",
                R.drawable.ic_croque_monsieur_sandwich,
                "A sophisticated French grilled sandwich with smoked ham and Swiss cheese, smothered in a rich, creamy béchamel sauce and toasted until golden."
            ),
            arrayOf(
                "Cubano Sandwich",
                "90 DH",
                R.drawable.ic_cuban_sandwich,
                "Authentic Cuban bread pressed with roasted pork, glazed ham, Swiss cheese, pickles, and yellow mustard for a perfectly crispy and savory bite."
            ),
            arrayOf(
                "Po' Boy Sandwich",
                "105 DH",
                R.drawable.ic_po_boy_sandwich,
                "A Louisiana staple featuring crispy fried shrimp or oysters served on a French baguette with lettuce, tomato, pickles, and a zesty remoulade sauce."
            ),
            arrayOf(
                "Caprese Sandwich",
                "70 DH",
                R.drawable.ic_caprese_sandwich,
                "A fresh and light Italian vegetarian option with thick slices of mozzarella, ripe tomatoes, fresh basil leaves, and a drizzle of balsamic glaze on ciabatta."
            ),
            arrayOf(
                "Monte Cristo Sandwich",
                "95 DH",
                R.drawable.ic_monte_cristo_sandwich,
                "The ultimate sweet-and-savory treat: a ham and turkey sandwich dipped in egg batter, pan-fried, and dusted with powdered sugar. Served with jam."
            ),
            arrayOf(
                "BLT Sandwich",
                "65 DH",
                R.drawable.ic_blt_sandwich,
                "The perfect simple trio of crispy smoked bacon, fresh iceberg lettuce, and juicy tomato slices with a spread of mayonnaise on toasted sourdough."
            )
        )

        val liste = findViewById<ListView>(R.id.listview1)

        liste.adapter = object : BaseAdapter() {
            override fun getCount() = sandwiches.size
            override fun getItem(position: Int) = sandwiches[position]
            override fun getItemId(position: Int) = position.toLong()
            override fun getView(position: Int, view: View?, parent: ViewGroup?): View? {
                val itemView = view ?: layoutInflater.inflate(R.layout.activity_liste_items1, parent, false)
                val infos = sandwiches[position]
                val nom = infos[0] as String
                val price = infos[1] as String
                val image = infos[2] as Int

                itemView.findViewById<ImageView>(R.id.sandwich_picture).setImageResource(image)
                itemView.findViewById<TextView>(R.id.sandwich_name).text = nom
                itemView.findViewById<TextView>(R.id.sandwich_price).text = price

                return itemView
            }
        }


        liste.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, SandwichDetailActivity::class.java)
            val infos = sandwiches[position]
            intent.putExtra("sandwich_name", infos[0] as String)
            intent.putExtra("sandwich_image", infos[2] as Int)
            intent.putExtra("sandwich_price", infos[1] as String)
            intent.putExtra("sandwich_description", infos[3] as String)
            startActivity(intent)
        }



    }
}