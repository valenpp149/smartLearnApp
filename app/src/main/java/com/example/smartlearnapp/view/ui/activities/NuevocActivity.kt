package com.example.smartlearnapp.view.ui.activities

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.smartlearnapp.databinding.ActivityNuevocBinding

class NuevocActivity: AppCompatActivity(){

    lateinit var binding : ActivityNuevocBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNuevocBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tomarFoto.setOnClickListener{
            abrirCamara.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }

    val abrirCamara = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == RESULT_OK){
            val data = result.data!!
            val bitmap = data.extras?.get("data") as Bitmap
            binding.imageView3.setImageBitmap(bitmap)
        }
    }
}