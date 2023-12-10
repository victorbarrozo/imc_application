package com.victorbarrozo.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {


    private lateinit var textPeso : TextView
    private lateinit var textAltura : TextView
    private lateinit var textResultado : TextView
    lateinit var btnInicio : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso_informado)
        textAltura = findViewById(R.id.text_altura_informado)
        textResultado = findViewById(R.id.text_resultado)
        btnInicio = findViewById(R.id.btn_inicio)

               btnInicio.setOnClickListener {
            finish()
        }

        val bundle = intent.extras
        if(bundle!= null){
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado $peso Kg"
            textAltura.text = "Altura informado $altura m"

            val imc = peso/ (altura*altura)
            textResultado.text = if(imc<18.5){
                "Baixo"
            }else if( imc in 18.5 .. 24.9){
                "Normal"
            }else if( imc in 25.0 .. 29.9){
               "Sobrepeso"
            }else{
                "obeso"
            }


        }

    }
}