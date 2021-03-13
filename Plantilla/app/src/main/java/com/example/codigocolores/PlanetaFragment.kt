package com.example.codigocolores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codigocolores.databinding.FragmentPlanetaBinding


class PlanetaFragment : Fragment() {
    private lateinit var binding: FragmentPlanetaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentPlanetaBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }


}