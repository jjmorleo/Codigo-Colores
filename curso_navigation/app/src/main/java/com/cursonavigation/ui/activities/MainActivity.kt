package com.cursonavigation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cursonavigation.R
import com.cursonavigation.databinding.ActivityMainBinding
import com.cursonavigation.listeners.MainListener

class MainActivity : AppCompatActivity(), MainListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bottomNavView = binding.bottomNavView
        val navController = findNavController(R.id.nav_host_fragment)
        bottomNavView.setupWithNavController(navController)
    }

    override fun showBottomNavigation() {
        binding.bottomNavView.visibility= View.VISIBLE
    }

}