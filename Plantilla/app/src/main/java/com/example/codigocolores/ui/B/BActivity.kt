package com.example.codigocolores.ui.B

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codigocolores.databinding.ActivityBBinding

class BActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //IF comprobar si la pantalla esta rotada

        //if ()

        val boton = intent.extras!!.getInt("BOTON_PULSADO")

        val fragment = BFragment.newInstance(boton)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(binding.activityBFrameLayout.id, fragment)
        transaction.commit()
    }
}