package com.example.actividad4_lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import java.text.ChoiceFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provincias = arrayOf(
            "Ávila",
            "Burgos",
            "León",
            "Palencia",
            "Salamanca",
            "Segovia",
            "Soria",
            "Valladolid",
            "Zamora"
        )

        //Enlazamos con los elementos de la interfaz
        val ListViewProvincias = findViewById<ListView>(R.id.provinceListView)
        val TextViewProvinciaSeleccionadad = findViewById<TextView>(R.id.selectedProvinceTextView)
        var listSelecionadas = ArrayList<Int>()

        //Declaramos un adaptador
        //Pasamos el contexto
        //El layout de la vista
        //El array que se va a mostrar
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, provincias)
        //val adapter = ArrayAdapter(this, R.layout.fila, provincias)
        ListViewProvincias.adapter = adapter

        //Fijamos un escuchador
        ListViewProvincias.onItemClickListener =
                //Interfaz anidada para manejar eventos
                //Primer _ : referencia al objeto que desencadenó el evento (no se va a usar)
                //Segundo _: referencia a la vista del elemento de la lista que se ha hecho click (no se va a usar)
                //position: posición del elmento de la lista donde se ha hecho click
                //Último _: referencia al ID del elemento que se ha hecho clic
                //Función que muestra el TextView utilizando la posición
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedProvince = provincias[position]
                if (listSelecionadas.contains(position))
                    listSelecionadas.remove(position)
                else
                    listSelecionadas.add(position)

                if (listSelecionadas.count() > 0) {
                    var texto = "Provincias seleccionadas: "
                    listSelecionadas.forEach { x ->
                        if (listSelecionadas.last() == x)
                            texto += provincias[x]
                        else
                            texto += provincias[x] + ", "
                    }
                    TextViewProvinciaSeleccionadad.text = texto
                } else
                    TextViewProvinciaSeleccionadad.text =
                        "Ninguna pronvincia seleccionada"
            }
    }
}