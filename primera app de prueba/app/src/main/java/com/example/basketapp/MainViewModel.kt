package com.example.basketapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val scoreA = MutableLiveData("0")
    val ScoreB = MutableLiveData("0")
    var Ganador = MutableLiveData("Empate")
}