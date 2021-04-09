package com.example.codigocolores.ui

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.codigocolores.ColorActivity
import com.example.codigocolores.R
import com.example.codigocolores.databinding.ActivityAuthBinding
import com.example.codigocolores.ui.A.AActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_MyTheme)
        super.onCreate(savedInstanceState)
        auth = Firebase.auth



        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.mainIniciarSeccion.setOnClickListener {
            val editPassword = binding.mainTiePassword
            val password = editPassword.text

            if(password.isNullOrBlank()) {
                binding.mainIntroducirPassword.error = "¡La contraseña no puede estar vacia!"
                return@setOnClickListener
            }
            val intent = Intent(this, AActivity ::class.java)
            startActivity(intent)
        }
        binding.mainTiePassword.addTextChangedListener {
            val size = it!!.length
            if (size<5){
                binding.mainIntroducirPassword.error = "Cracteres $size/5"
            }else{
                binding.mainIntroducirPassword.error = ""
            }
        }
        binding.mainTiePassword.setOnClickListener {
            val textInputEditText = it as TextInputEditText //Casteo

            //Recuperamos el texto del editext lo convertimos a string y de este string comprobamos su longitud
            val size = textInputEditText.text.toString().length
            if (size<5) {
                binding.mainIntroducirPassword.error = "Cracteres $size/5"
            }else{
                binding.mainIntroducirPassword.error = ""
            }

        }
        binding.mainRegistrate.setOnClickListener {
            val intent = Intent (this, RegistroActivity::class.java)
            startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }
        binding.mainTiePassword.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.mainIntroducirPassword.error = ""
            }
        }
    }


}