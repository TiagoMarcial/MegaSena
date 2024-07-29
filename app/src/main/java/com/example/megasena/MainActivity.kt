package com.example.megasena

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var prefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTxt: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.text_result)
        val btnGen: Button = findViewById(R.id.btn_generate)

        prefs = getSharedPreferences("db", Context.MODE_PRIVATE)
        val result = prefs.getString("result", "Nenhum registro salvo!")
        if (result !=null) {
            txtResult.text = "Ultima aposta: $result"
        }

        btnGen.setOnClickListener {
            val text = editTxt.text.toString()
            numberGenerator(text, txtResult)

        }
    }

        private fun numberGenerator(text: String, txtResult: TextView){

            if (text.isNotEmpty()) {
                val qtd = text.toInt()
                if(qtd in 6..15 || qtd == 22) {
                    val random = Random.Default
                    val numbers = mutableSetOf<Int>()
                    while (true) {
                        val number = random.nextInt(1, 60)
                        numbers.add(number)
                        txtResult.setText(numbers.joinToString(" - "))
                        val editor = prefs.edit()
                        editor.putString("result", txtResult.text.toString())
                        val saved = editor.commit()
                        Log.i("teste2", "foi salvo: $saved")
                        if (numbers.size == qtd) {
                            break
                        }
                    }

                    for (x in numbers) {
                        Log.i("teste", "numero $x")
                    }
                } else {
                    Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_SHORT).show()
            }
        }

}