package com.example.smartlearnapp.view.ui.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import com.example.smartlearnapp.R
import com.example.smartlearnapp.databinding.ActivityLoginBinding


class LoginActivity : Activity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ingreso.setOnClickListener{validar()}
        binding.registro.setOnClickListener{irARegistro()}
        binding.recuperar.setOnClickListener{recuperarCuenta()}
    }
    fun validar(){
        val correo: String = binding.email.text.toString()
        val clave: String = binding.password.text.toString()

        var pref = getSharedPreferences(correo, Context.MODE_PRIVATE)
        var correo2 = pref.getString("email", "")
        var clave2 = pref.getString("contraseña", "")
        if(correo.isEmpty()){
            binding.email.setHint("Ingrese su correo")
            binding.email.setHintTextColor(Color.RED)
        }else if(clave.isEmpty()){
            binding.password.setHint("Ingrese su contraseña")
            binding.password.setHintTextColor(Color.RED)
        }else if(correo==correo2){
            if(clave==clave2){
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_LONG).show()
        }
    }

    fun irARegistro(){
        startActivity(Intent(this, registrarActivity::class.java))
    }

    fun recuperarCuenta(){
        Toast.makeText(this, "Contraseña enviada al correo", Toast.LENGTH_LONG).show()
    }
}