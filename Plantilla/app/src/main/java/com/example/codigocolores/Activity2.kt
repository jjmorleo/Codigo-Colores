package com.example.codigocolores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codigocolores.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.main2IniciarSeccion.setOnClickListener {
            val intent = Intent (this, AuthActivity::class.java)
            startActivity(intent)
        }

        
    }
}