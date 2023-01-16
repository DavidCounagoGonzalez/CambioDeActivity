package com.example.cambioactivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondactivity)

        val intent = getIntent()

        val num1 = intent.getIntExtra("sumando1", 0)

        val num2 = intent.getIntExtra("sumando2", 0)

        intent.putExtra("suma", num1 + num2)

        Log.d("MENSAJES", "actualizado intent")

        setResult(Activity.RESULT_OK, intent)

        Log.d("MENSAJES", "actualizado resultado")

        finish()
    }
}