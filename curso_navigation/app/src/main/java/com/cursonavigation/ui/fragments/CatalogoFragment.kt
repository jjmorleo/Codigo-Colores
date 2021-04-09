package com.cursonavigation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cursonavigation.R
import com.cursonavigation.databinding.FragmentCatalogoBinding


class CatalogoFragment : Fragment() {
    private var _binding: FragmentCatalogoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCatalogoBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val binding= _binding!!
        val view = binding.root
        return view
    }


}