package com.example.codigocolores

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.codigocolores.databinding.ActivityRegistroBinding


class RegistroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.main2IniciarSeccion.setOnClickListener {
            val intent = Intent (this, AuthActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

        binding.main2Registrate.setOnClickListener {
            val editName = binding.main2NameTie
            val name = editName.text
            if (name.isNullOrBlank()){
                binding.main2Name.error = "Debes introducir el nombre completo"
            }else{
                binding.main2Name.error = ""
            }

        }


        
    }
}