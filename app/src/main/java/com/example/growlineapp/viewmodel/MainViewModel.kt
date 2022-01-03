package com.example.growlineapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.growlineapp.data.retrofit.RetrofitBuilder
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    //다른화면으로 넘어갈때 bottom nav bar 숨기기 or 보이기 (true = 보이기, false = 숨기기)
    private val _eventActionView = MutableLiveData(true)
    val eventActionView: LiveData<Boolean> get() = _eventActionView


    private val TAG = "MainViewModel - TAG"


    private var _id = MutableLiveData<String>()
    val id: LiveData<String>
        get() = _id

    private var _summary = MutableLiveData<String>()
    val summary: LiveData<String>
        get() = _summary

    private var _koin = MutableLiveData<Int>()
    val koin: LiveData<Int>
        get() = _koin

    private var _userName = MutableLiveData<String>()
    val userName: LiveData<String>
        get() = _userName

    fun setActionView(content: Boolean) {
        _eventActionView.value = content
    }


    fun setUserId(user_id: String) {
        _id.value = user_id
    }


    fun getUserInfo(input_id: String) {
        val queries: HashMap<String, String> = HashMap()

        queries["user_id"] = input_id

        viewModelScope.launch {
            val response = RetrofitBuilder.api.getUserProfile(queries)
            if (response.isSuccessful) {
                val result = response.body()
                _userName.value = result!!.user_id
                _koin.value = result.user_koin
                _summary.value = result.user_summary

            }
        }

    }


    fun getPostList() {
        viewModelScope.launch {
            val response = RetrofitBuilder.api.getPostList()
            if (response.isSuccessful) {

            }
        }
    }
}