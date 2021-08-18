package me.geofferyj.hng_greeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShowGreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_greeting)

        val name = intent.getStringExtra("name")
        val nameTv : TextView = findViewById(R.id.name_tv)

        nameTv.text = name



    }
}