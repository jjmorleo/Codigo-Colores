package com.cursonavigation.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cursonavigation.models.Producto

class ProductoViewModel : ViewModel() {
    //INICIALIZADOR AUTOMATICO
    private val productos: MutableLiveData<List<Producto>> by lazy {
        MutableLiveData<List<Producto>>().also {
            //cargarProdustos()
        }

    }

   /* private fun cargarProdustos{
        //Añadir datos al Mutable live data

    }

    /*fun obtenerProductos() = productos*/
    //PROTECCION PARA EVITAR QUE SE MODIFIQUE LOS DATOS QUE ENVIAMOS
    fun obtenerProductos(): LiveData<List<Producto>> {
        return productos

    }*/


}