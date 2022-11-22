package com.example.smartlearnapp.view.ui.activities

import android.app.Activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.example.smartlearnapp.R
import com.example.smartlearnapp.databinding.ActivityHomeBinding
import com.example.smartlearnapp.databinding.ActivityRegistrarBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cursosF = CursosFragment()
        val perfilF = PerfilFragment()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.cursos -> {
                    menu(cursosF)
                    true
                }
                R.id.perfil -> {
                    menu(perfilF)
                    true
                }
                else -> false
            }
        }
    }

    fun menu(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }

    }
}