package com.cursonavigation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.navigation.fragment.NavHostFragment
import com.cursonavigation.R
import com.cursonavigation.databinding.FragmentRegistroBinding
import com.google.android.material.textfield.TextInputEditText


class RegistroFragment : Fragment() {
    private var _binding: FragmentRegistroBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        val binding = _binding!!
        val view = binding.root

        binding.main2NameTie.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.main2Name.error = ""
        }
        binding.usuarioTie.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.main2Usuario.error = ""
        }
        binding.main2TiePassword.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.main2TilPassword.error = ""
        }
        binding.main2TieRepitePassword.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.main2TilRepitePassword.error = ""
        }
        binding.main2NameTie.setOnClickListener {
            val text = it as TextInputEditText
            if (text.text!!.isNotEmpty()) {

                binding.main2Name.error = ""
            }
        }
        binding.usuarioTie.setOnClickListener {
            val text = it as TextInputEditText
            if (text.text!!.isNotEmpty()) {
                binding.main2Usuario.error = ""
            }
        }
        binding.main2TiePassword.setOnClickListener {
            val text = it as TextInputEditText
            if (text.text!!.isNotEmpty()) {
                binding.main2TilPassword.error = ""

            }
        }
        binding.main2TieRepitePassword.setOnClickListener {
            val text = it as TextInputEditText
            if (text.text!!.isNotEmpty()) {

                binding.main2TilRepitePassword.error = ""

            }
        }

        binding.main2TieRepitePassword.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.main2BtnRegistrar.performClick()
            }
            false

        }

        binding.main2BtnRegistrar.setOnClickListener {

            val nombre = binding.main2NameTie
            val email = binding.usuarioTie
            val pass1 = binding.main2TiePassword
            val pass2 = binding.main2TieRepitePassword

            val attr = listOf(nombre, email, pass1, pass2)
            var error = false
            attr.forEach {
                if (it.obtenerTexto().isBlank()) {
                    error = true
                    when (it.id) {
                        R.id.main2_name_tie -> {
                            binding.main2Name.error = "Debes de introducir tu nombre completo"
                        }
                        R.id.usuario_tie -> {
                            binding.main2Usuario.error = "Debes de introducir tu email"
                        }
                        R.id.main2_tie_password -> {
                            binding.main2TilPassword.error = "Debes de introducir una contraseña"
                        }
                        R.id.main2_tie_repite_password -> {
                            binding.main2TilRepitePassword.error =
                                "Debes de introducir nuevamente la contraseña"

                        }
                    }
                }
            }
            if (error)
                return@setOnClickListener
            if (pass1.obtenerTexto().length < 5) {
                binding.main2TilPassword.error = "La contraseña debe de tener como mínimo 5 letras"
                return@setOnClickListener
            }
            if (!pass1.obtenerTexto().equals(pass2.obtenerTexto())) {
                binding.main2TilPassword.error = "Las contraseñas no coinciden"
                binding.main2TilRepitePassword.error = "Las contraseñas no coinciden"
                return@setOnClickListener
            }
            val actions = RegistroFragmentDirections.actionToLoginFragment(setData())
            NavHostFragment.findNavController(this).navigate(actions)

            //TODO volver a login con datos

            // Inflate the layout for this fragment
        }
        binding.main2BtnCancelar.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_to_loginFragment)
            //TODO volver a login sin datos
        }
        return view
    }

    fun setData() = arrayOf(
        _binding!!.usuarioTie.text.toString(),
        _binding!!.main2TiePassword.text.toString()
    )

    fun TextInputEditText.obtenerTexto(): String {
        return text.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}