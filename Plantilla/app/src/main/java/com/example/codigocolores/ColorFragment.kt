package com.example.codigocolores

import android.content.Context
import android.net.sip.SipSession
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.codigocolores.databinding.FragmentColorBinding


class ColorFragment : Fragment() {

    private lateinit var binding: FragmentColorBinding
    var listener: ColorListener? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentColorBinding.inflate(layoutInflater)
        val view = binding.root
        binding.button.setOnClickListener {
            val color = binding.fragmentColorEdt.text.toString()
            listener?.guardarColor(color)

        }
        return view
    }
    interface ColorListener {
        fun guardarColor(nombre: String)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ColorListener
    }
}