package com.example.navegation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val name = MutableLiveData("")
    val lastname = MutableLiveData("")
}