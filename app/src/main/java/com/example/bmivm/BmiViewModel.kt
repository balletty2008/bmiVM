package com.example.bmivm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.MutableState

class BmiViewModel: ViewModel() {
    private var height: Float = 0.00f
    private var weight: Float = 0.00f

    var bmi: MutableState<Float> = mutableStateOf(0.00f)
        private set

    var heightInput by mutableStateOf("")
        private set

    var weightInput by mutableStateOf("")
        private set

    fun changeHeightInput(value: String) {
        heightInput = value
        calculate()
    }

    fun changeWeightInput(value: String) {
        weightInput = value
        calculate()
    }

    private fun calculate() {
        height = heightInput.toFloatOrNull() ?: 0.00f
        weight = weightInput.toFloatOrNull() ?: 0.00f
        bmi.value = if(weight>0 && height>0) weight / (height*height) else 0.00f
    }
}