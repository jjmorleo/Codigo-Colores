package com.example.codigocolores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codigocolores.databinding.ActivityColorBinding

class ColorActivity : AppCompatActivity(), ColorFragment.ColorListener {
    private lateinit var binding: ActivityColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun guardarColor(nombre: String) {
        var texto = binding.textView.text.toString()
        texto += "$nombre \n"
        binding.textView.text = texto
    }
}