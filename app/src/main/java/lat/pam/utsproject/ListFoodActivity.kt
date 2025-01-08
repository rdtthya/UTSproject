package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Cheese Cake", "Kue yang pake keju", R.drawable.cheesecake),
            Food("Cireng", "Aci yang digoreng", R.drawable.cireng),
            Food("Donut", "Kue bolong tengah nya", R.drawable.donut),
            Food("Kopi Hitam", "Kopi warna hitam", R.drawable.kopi_hitam),
            Food("Mie Goreng", "Mie yang direbus tapi goreng", R.drawable.mie_goreng),
            Food("Nasi Goreng", "Nasi yang digoreng", R.drawable.nasigoreng),
            Food("Sparkling Tea", "Teh yang sparkling", R.drawable.sparkling_tea),
        )

        adapter = FoodAdapter(foodList) { selectedFood ->

            val intent = Intent(this, OrderActivity::class.java)

            intent.putExtra("foodName", selectedFood.name)
            startActivity(intent)
        }
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}