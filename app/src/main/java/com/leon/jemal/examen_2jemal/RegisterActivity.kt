package com.leon.jemal.examen_2jemal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.leon.jemal.examen_2jemal.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

        private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeComponents()
    }
    fun observeComponents() {
        binding.btnGuardar.setOnClickListener {
            if (isEmptyInputs()) {
                Toast.makeText(this, "Hay algún campo vacío", Toast.LENGTH_SHORT).show()
            } else {
                goDetailActivity()
            }
        }
    }

    fun goDetailActivity() {
        val fullName = binding.edtNombre.text.toString()
        val phoneNumber = binding.edtNumeroCliente.text.toString()
        val product = binding.edtProductos.text.toString()
        val city = binding.edtCiudad.text.toString()
        val address = binding.edtDireccion.text.toString()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(FULL_NAME_KEY, fullName)
        intent.putExtra(PHONE_NUMBER_KEY, phoneNumber)
        intent.putExtra(PRODUCT_KEY, product)
        intent.putExtra(CITY_KEY, city)
        intent.putExtra(ADDRESS_KEY, address)
        startActivity(intent)
    }



    fun isEmptyInputs(): Boolean {
        return binding.edtNombre.text.isEmpty() ||
                binding.edtNumeroCliente.text.isEmpty() ||
                binding.edtProductos.text.isEmpty() ||
                binding.edtCiudad.text.isEmpty() ||
                binding.edtDireccion.text.isEmpty()
    }
}