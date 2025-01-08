package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val foodName = intent.getStringExtra("foodName")
        val tvFoodName: TextView = findViewById(R.id.etFoodName)
        tvFoodName.text = foodName ?: "No food selected"

        val btnOrder: Button = findViewById(R.id.btnOrder)
        btnOrder.setOnClickListener {
            val servings = findViewById<EditText>(R.id.etServings).text.toString()
            val orderName = findViewById<EditText>(R.id.etName).text.toString()
            val notes = findViewById<EditText>(R.id.etNotes).text.toString()

            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("foodName", foodName)
            intent.putExtra("servings", servings)
            intent.putExtra("orderName", orderName)
            intent.putExtra("notes", notes)

            startActivity(intent)
        }
    }
}