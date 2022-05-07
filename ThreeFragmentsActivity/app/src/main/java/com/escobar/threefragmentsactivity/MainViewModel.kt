package com.escobar.threefragmentsactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val meatsQuantity = MutableLiveData("")
    val complement = MutableLiveData("")
}