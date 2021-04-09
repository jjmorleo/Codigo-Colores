package com.example.codigocolores.ui.A

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codigocolores.databinding.ActivityABinding

class AActivity : AppCompatActivity() {
    lateinit var binding: ActivityABinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityABinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}