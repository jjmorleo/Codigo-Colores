package com.example.codigocolores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codigocolores.databinding.ActivityPlanetaBinding

class PlanetaActivity : AppCompatActivity(), PlanetaFragment.PlanetaListener {
    private lateinit var binding: ActivityPlanetaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun guardarPlaneta(nombre: String) {
        var texto = binding.textview.text.toString()
        texto += "$nombre \n"
        binding.textview.text = texto
    }
}