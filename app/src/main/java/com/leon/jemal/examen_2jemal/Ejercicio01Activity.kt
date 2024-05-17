package com.leon.jemal.examen_2jemal


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.leon.jemal.examen_2jemal.databinding.ActivityEjercicio01Binding
import android.view.View

class Ejercicio01Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio01Binding.inflate(layoutInflater)
        //enableEdgeToEdge()
        setContentView(binding.root)
        listenerComponentUi()
        }

    private fun listenerComponentUi() {
        binding.btnMostrar.setOnClickListener {
            Mostrar()
        }
        binding.btnOcultar.setOnClickListener {
            Ocultar()
        }
    }
    private fun Mostrar() {
        binding.cardVerde.visibility = View.VISIBLE
    }
    private fun Ocultar() {
        binding.cardVerde.visibility = View.GONE
    }
}
