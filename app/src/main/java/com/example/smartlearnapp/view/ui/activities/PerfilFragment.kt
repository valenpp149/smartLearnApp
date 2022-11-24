package com.example.smartlearnapp.view.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.smartlearnapp.R
import com.example.smartlearnapp.databinding.FragmentPerfilBinding


class PerfilFragment : Fragment() {
    private var _binding : FragmentPerfilBinding? = null
    private val binding get() = _binding!!
    private var but : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPerfilBinding.inflate(inflater)
        var view: ConstraintLayout = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        but = binding.nuevo
        but!!.setOnClickListener {
            startActivity(Intent(context, NuevocActivity::class.java))
        }
    }
}