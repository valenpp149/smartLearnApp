package com.example.smartlearnapp.view.ui.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartlearnapp.R
import com.example.smartlearnapp.databinding.FragmentCursosBinding


class CursosFragment : Fragment(R.layout.fragment_cursos) {
    private var _binding: FragmentCursosBinding? = null
    private val binding get() = _binding!!
    private var lista2: MutableList<Cursos> = mutableListOf()
    private lateinit var recycler: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCursosBinding.inflate(inflater)
        var view: FrameLayout = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lista2.add(Cursos(nombre = "Ciencias", descripcion = "El sistema circulatorio", precio = "40000", R.drawable.user))
        lista2.add(Cursos(nombre = "Matematicas", descripcion = "Divisiones", precio = "35000", R.drawable.wave))
        lista2.add(Cursos(nombre = "Artes", descripcion = "Tecnicas de coloreado", precio = "30000", R.drawable.logo))
        lista2.add(Cursos(nombre = "Deportes", descripcion = "Baloncesto", precio = "30000", R.drawable.ic_baseline_local_phone_24))

        binding.listaCursos.apply{
            layoutManager=LinearLayoutManager(activity)
            adapter=Recyclerview(lista2)
        }
    }

}