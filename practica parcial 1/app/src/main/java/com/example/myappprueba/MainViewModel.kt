package com.example.myappprueba

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var query = MutableLiveData("")
    var result = Transformations.map(query) { textQuery ->
        if (textQuery.isEmpty())
            "Ingrese una palabra para obtener resultado"
        else
            "El resultado para la query es este $textQuery"
    }


    fun onSearch(){
    }
}