package com.leon.jemal.examen_2jemal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.leon.jemal.examen_2jemal.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listenerComponentUi()
        intent.extras?.let {
            showData(it)
        }
    }

    private fun showData(paramExtras: Bundle) {
        val nombreCliente = paramExtras.getString(FULL_NAME_KEY)
        val phone= paramExtras.getString(PHONE_NUMBER_KEY)
        val producto = paramExtras.getString(PRODUCT_KEY)
        val ciudad = paramExtras.getString(CITY_KEY)
        val direccion = paramExtras.getString(ADDRESS_KEY)

        binding.tvnombre.text = nombreCliente
        binding.tvPhoneNumber.text = phone
        binding.tvProduct.text = producto
        binding.tvCity.text = ciudad
        binding.tvAddress.text = direccion
    }

    private fun listenerComponentUi() {
        binding.btnPhone.setOnClickListener {
            Call()
        }
        binding.btnWsp.setOnClickListener {
            WhatsappMessage()
        }
        binding.btnMap.setOnClickListener {
            Map()
        }
    }

    private fun WhatsappMessage() {
        val phoneNumber = binding.tvPhoneNumber.text.toString()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
        startActivity(intent)
    }

    private fun Call() {
        val phoneNumber = binding.tvPhoneNumber.text.toString()
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+51$phoneNumber")
        startActivity(intent)
    }
    private fun Map() {
        val ciudad = Uri.encode(binding.tvCity.text.toString())
        val direccion = Uri.encode(binding.tvAddress.text.toString())
        val location = "$ciudad, $direccion"
        val uri = Uri.parse("geo:0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }



}