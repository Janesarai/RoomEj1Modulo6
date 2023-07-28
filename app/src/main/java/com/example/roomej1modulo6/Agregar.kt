package com.example.roomej1modulo6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.roomej1modulo6.databinding.FragmentAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Agregar.newInstance] factory method to
 * create an instance of this fragment.
 */
class Agregar : Fragment() {
    lateinit var binding: FragmentAgregarBinding
    private val tareaVM: TareaVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAgregarBinding.inflate(layoutInflater,container,false)
        initListener()
        cargarTarea()
        return binding.root
    }


    private fun initListener() {
        binding.btnAgregar.setOnClickListener{
            val texto = binding.edTarea.text.toString()

            guardarTarea(texto)
        }
    }

    private fun guardarTarea(texto: String) {
        val tarea = Tarea(texto, "fecha")
        tareaVM.insertarTarea(tarea)
    }
        private fun cargarTarea() {
            tareaVM.obtenerTareas().observe(viewLifecycleOwner) {
                val tasksAsText = it.joinToString("\n") { it.nombre }
                binding.tvTarea.text = tasksAsText
            }

        }
}

