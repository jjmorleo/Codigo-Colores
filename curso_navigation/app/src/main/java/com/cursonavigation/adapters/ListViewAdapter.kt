package com.cursonavigation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.cursonavigation.databinding.ItemProductoListViewBinding
import com.cursonavigation.models.Producto

class ListViewAdapter(context: Context, val vista: Int, val productos: List<Producto>)
    : ArrayAdapter<Producto>(context, vista, productos) {

    //SE INVOCARÁ TANTAS VECES COMO ELEMENTOS EXISTAN EN LA LISTA
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(vista, null)
        }

        val binding = ItemProductoListViewBinding.bind(view!!)
        val producto = productos[position]

        binding.itemProductoId.text = producto.id.toString()
        binding.itemProductoNombre.text = producto.nombre
        binding.itemProductoClases.text = producto.clases.toString()
        binding.itemProductoDescripcion.text = producto.descripcion
        binding.itemProductoPrecio.text = producto.precio.toString()

        return view
    }

}