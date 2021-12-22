package com.example.growlineapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //다른화면으로 넘어갈때 bottom nav bar 숨기기 or 보이기 (true = 보이기, false = 숨기기)


    private val _eventActionView = MutableLiveData(true)
    val eventActionView: LiveData<Boolean> get() = _eventActionView

    fun setActionView(content: Boolean) {
        _eventActionView.value = content
    }

}