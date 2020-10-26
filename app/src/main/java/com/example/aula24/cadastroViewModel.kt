package com.example.aula24

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class cadastroViewModel: ViewModel() {
    val onNomeChange: MutableLiveData<String> = MutableLiveData()
}