package com.cursonavigation.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.NavHostFragment
import com.cursonavigation.R
import com.cursonavigation.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = _binding!!.root
        val binding = _binding!!

        val data = arguments?.let {
            LoginFragmentArgs.fromBundle(it).data
        }

        data.let {
            binding.authTieUsuario.setText(it?.get(0))
            binding.mainTiePassword.setText(it?.get(1))
        }

        binding.mainTiePassword.setOnFocusChangeListener { _, hasFocus ->
            run {
                if (hasFocus) {
                    binding.mainIntroducirPassword.error = ""
                }
            }
        }

        binding.mainTiePassword.addTextChangedListener {

            val size = it!!.length
            if (size < 5) {
                binding.mainIntroducirPassword.error = "Caracteres $size/5"
            } else {
                binding.mainIntroducirPassword.error = ""
            }
        }

        binding.mainTiePassword.setOnClickListener {
            val textInputEditText = it as TextInputEditText //Casteo

            //Recuperamos el texto del editext lo convertimos a string y de este String comprobamos su longitud
            val size = textInputEditText.text.toString().length
            if (size < 5) {
                binding.mainIntroducirPassword.error = "Caracteres $size/5"
            } else {
                binding.mainIntroducirPassword.error = ""
            }
        }

        binding.mainIniciarSeccion.setOnClickListener {

            val editPassword = binding.mainTiePassword
            val password = editPassword.text

            if (password.isNullOrBlank()) {
                binding.mainIntroducirPassword.error = "La contraseña no puede estar vacia"
                return@setOnClickListener
            }

            val sharePrefs = activity?.getPreferences(Context.MODE_PRIVATE)!!
            with(sharePrefs.edit()) {
                putBoolean("logueado", true)
                apply()
            }
            //TODO ir al siguiente fragment
            NavHostFragment.findNavController(this).navigate(R.id.action_to_bottom_nav_graph)
        }

        binding.mainRegistrate.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_to_registroFragment)
            //TODO ir al registro
        }
        // Inflate the layout for this fragment
        return view

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}