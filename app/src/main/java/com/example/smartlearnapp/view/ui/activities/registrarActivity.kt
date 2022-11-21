package com.example.smartlearnapp.view.ui.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smartlearnapp.databinding.ActivityLoginBinding
import com.example.smartlearnapp.databinding.ActivityRegistrarBinding

class registrarActivity : Activity(){
    lateinit var binding: ActivityRegistrarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.registrar.setOnClickListener{guardarUsuario()}

    }

    fun guardarUsuario(){
        val nombre:String = binding.nombree.text.toString()
        val cedula:String = binding.identificacion.text.toString()
        val correo:String = binding.correoo.text.toString()
        val direccion:String = binding.direccion.text.toString()
        val telefono:String = binding.telefono.text.toString()
        val clave:String = binding.clavee.text.toString()

        var pref =getSharedPreferences(correo, Context.MODE_PRIVATE)
        var editar= pref.edit()
        editar.putString("email", correo)
        editar.putString("nombre", nombre)
        editar.putString("identificacion", cedula)
        editar.putString("direccion", direccion)
        editar.putString("telefono", telefono)
        editar.putString("contraseña", clave)

        editar.commit()
        Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}