package com.example.cambioactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    //definir request_code
    val RESULTADO_UNO = 1
    val RESULTADO_DOS =  2
    val RESULTADO_TRES = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstactivity)

        val gosecond= findViewById<Button>(R.id.goSecond)

        gosecond.setOnClickListener{
            val intent = Intent(this , SecondActivity::class.java)
            //Datos adicionales al intent
            intent.putExtra("sumando1", 3)
            intent.putExtra("sumando2", 2)
            //Inicia la segunda actividad
            startActivityForResult(intent, RESULTADO_UNO)

            intent.putExtra("sumando1", 7)
            intent.putExtra("sumando2", 14)
            startActivityForResult(intent, RESULTADO_DOS)

            intent.putExtra("sumando1", 1263)
            intent.putExtra("sumando2", 137)
            startActivityForResult(intent, RESULTADO_TRES)
        }

    }

    @Deprecated("Deprecated a partir de API 30")

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val suma1 = findViewById<TextView>(R.id.Suma1)
        val suma2 = findViewById<TextView>(R.id.Suma2)
        val suma3 = findViewById<TextView>(R.id.Suma3)

        if(resultCode != Activity.RESULT_OK) return
        // Puedo distinguir diferentes acciones según el requestCode
        when(requestCode) {
            RESULTADO_UNO -> {
                // si el intent no es null muestro el resultado
                suma1.text = data?.getIntExtra("suma", 0).toString()
            }
            RESULTADO_DOS ->{
                suma2.text = data?.getIntExtra("suma", 0).toString()
            }
            RESULTADO_TRES -> {
                suma3.text = data?.getIntExtra("suma", 0).toString()
            }
            // Other result codes
            else -> {}
        }
    }
}