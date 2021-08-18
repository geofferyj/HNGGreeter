package me.geofferyj.hng_greeter

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hngBtn : MaterialCardView = findViewById(R.id.hng_btn)
        val i4gBtn : MaterialCardView = findViewById(R.id.i4g_btn)
        val zuriBtn : MaterialCardView = findViewById(R.id.zuri_btn)
        val hotelsNgBtn : MaterialCardView = findViewById(R.id.hotels_ng_btn)
        val button: MaterialButton = findViewById(R.id.button)
        val nameTV: TextInputEditText = findViewById(R.id.main_name_tv)

        button.setOnClickListener {
            val name = nameTV.text.toString()

            if (name.isBlank()) {
                Toast.makeText(this, "Name cannot be blank", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            Intent(this, ShowGreetingActivity::class.java).apply {
                putExtra("name", name)
                startActivity(this)
            }

        }


        hngBtn.setOnClickListener {
            openInBrowser("internship.zuri.team")
        }
        i4gBtn.setOnClickListener {
            openInBrowser("ingressive.org")
        }
        zuriBtn.setOnClickListener {
            openInBrowser("zuri.team")
        }
        hotelsNgBtn.setOnClickListener {
            openInBrowser("hotels.ng")
        }
    }


    private fun openInBrowser(url: String){
            val defaultBrowser = Intent.makeMainSelectorActivity(
                Intent.ACTION_MAIN,
                Intent.CATEGORY_APP_BROWSER
            )
            defaultBrowser.data = Uri.parse(url)
            startActivity(defaultBrowser)
    }
}