package com.example.aula24

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class cadastroViewModel: ViewModel() {
    val onNomeChange: MutableLiveData<String> = MutableLiveData()
    val onChangeTab: MutableLiveData<Int> = MutableLiveData()

    fun setOnNomeChange(nome: String) {
        onNomeChange.postValue(nome)
    }

    fun setOnChangeTab(tab: Int) {
        onChangeTab.postValue(tab)
    }
}