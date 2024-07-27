package com.example.megasena

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Daqui começa a se fazer o app
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //aqui busca e da a referência aos objetos
        val editTxt: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.text_result)
        val btnGen: Button = findViewById(R.id.btn_generate)

        // Opção 2: btnGen.setOnClickListener(buttonClickListener)
        //Escutar as inteções
        //Opção 1: XML (fun buttonClicked, colocar onClick no xml)
        //Opção 2: Variável do tipo objeto Anonimo View.OnclickListener (interface)
        //Opção 3: mais simples e recomendavel: declarar o bloco que será disparado pelo one click
        btnGen.setOnClickListener { Log.i("teste", "botão clicado!") } // opção 3

    }
    //Opção2
    /*val buttonClickListener = View.OnClickListener {
        //quem chama o onClick é o SDK que dispara o método apos o evento touch
            Log.i("teste", "botão clicado!")
        }*/

    /*fun buttonClicked(view: View) {
    Log.i("teste", "botão clicado!")
    }*/
}