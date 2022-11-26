package com.example.smartlearnapp.view.ui.activities

import android.app.Activity
import android.content.Intent
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.smartlearnapp.BuildConfig
import com.example.smartlearnapp.databinding.ActivityNuevocBinding
import java.io.File

class NuevocActivity: AppCompatActivity(){

    lateinit var binding : ActivityNuevocBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNuevocBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tomarFoto.setOnClickListener{
            //abrirCamara.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{
                cargarImagen()
                val fotouri= FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID+".fileprovider",file)
                it.putExtra(MediaStore.EXTRA_OUTPUT,fotouri)
            }
            abrirCamara.launch(intent)
        }
    }

    val abrirCamara = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == RESULT_OK){
            //val data = result.data!!
            //val bitmap = data.extras?.get("data") as Bitmap
            val bitmap = BitmapFactory.decodeFile(file.toString())
            binding.imageView3.setImageBitmap(bitmap)
        }
    }


    private lateinit var file: File
    private fun cargarImagen(){
        val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        file = File.createTempFile("Foto_${System.currentTimeMillis()}_", ".jpg", dir)
    }
}