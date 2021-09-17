package com.example.kotlinintro

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private var name: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val text = findViewById<TextView>(R.id.txtOutput)

        intent.extras?.let { bundle ->
            // name = bundle.getString("name") ?: "" // if null set ""
            name = bundle.getString("name")
        }


        text.text = name

        val button = findViewById<Button>(R.id.btnAction)
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result", "New data from second activity")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}