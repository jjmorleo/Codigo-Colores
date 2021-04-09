package com.example.codigocolores.ui.A

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.codigocolores.databinding.ActivityABinding
import com.example.codigocolores.databinding.FragmentABinding
import com.example.codigocolores.ui.B.BActivity
import com.example.codigocolores.ui.B.BFragment



class AFragment : Fragment() {
    private var binding: FragmentABinding? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentABinding.inflate(inflater, container, false)
        val view = binding!!.root

        binding!!.fragmentAButon1.setOnClickListener {
            clicarBoton(1)
        }
        binding!!.fragmentAButon2.setOnClickListener {
            clicarBoton(2)
        }
        binding!!.fragmentAButon3.setOnClickListener {
            clicarBoton(3)
        }
        binding!!.fragmentAButon4.setOnClickListener {
            clicarBoton(4)
        }
        binding!!.fragmentAButon5.setOnClickListener {
            clicarBoton(5)
        }
        binding!!.fragmentAButon6.setOnClickListener {
            clicarBoton(6)
        }

        return view
    }

    fun clicarBoton(boton: Int) {
        val main = activity as AActivity
        val mainBinding = ActivityABinding.bind(main.binding.root)

        if (mainBinding.activityAFrameLayout != null) {
            val fragment = BFragment.newInstance(boton)
            val manager = parentFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(mainBinding.activityAFrameLayout.id, fragment)
            transaction.commit()

        } else {
            val intent = Intent(this.context, BActivity::class.java)
            intent.putExtra("BOTON_PULSADO", boton)
            startActivity(intent)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }



}