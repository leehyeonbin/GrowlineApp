package com.example.growlineapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.growlineapp.data.retrofit.RetrofitBuilder
import kotlinx.coroutines.launch
import retrofit2.http.QueryMap

class MainViewModel : ViewModel() {
    //다른화면으로 넘어갈때 bottom nav bar 숨기기 or 보이기 (true = 보이기, false = 숨기기)
    private val _eventActionView = MutableLiveData(true)
    val eventActionView: LiveData<Boolean> get() = _eventActionView


    private val TAG = "MainViewModel - TAG"


    private var _no_clean = MutableLiveData<Int>()
    val no_clean : LiveData<Int>
        get() = _no_clean

    private var _choose_sit = MutableLiveData<Int>()
    val choose_sit : LiveData<Int>
        get() = _choose_sit

    private var _outside = MutableLiveData<Int>()
    val outside : LiveData<Int>
        get() = _outside

    private var _coin = MutableLiveData<Int>()
    val coin: LiveData<Int>
        get() = _coin

    private var _userName = MutableLiveData<String>()
    val userName: LiveData<String>
        get() = _userName

    private var _userInfo_result = MutableLiveData(false)
    val userInfo_result : LiveData<Boolean>
        get() = _userInfo_result

    fun setActionView(content: Boolean) {
        _eventActionView.value = content
    }





    fun getUserInfo(user : String) {
        val querys : HashMap<String, String> = HashMap()
        querys["id"] = user
        viewModelScope.launch {
            val response = RetrofitBuilder.api.getUserProfile(querys)
            Log.d(TAG, "retrofit 통신 실행")
            if (response.isSuccessful) {
                val result = response.body()
                Log.d(TAG,result.toString())
                _coin.value = result!!.coin
                _userName.value = result.name
                _no_clean.value = result.no_clean
                _choose_sit.value = result.choose_sit
                _outside.value = result.outside
                _userInfo_result.value = true
            }
        }
    }

    private val _shopping_result = MutableLiveData<String>()
    val shopping_result : LiveData<String>
        get() = _shopping_result



    fun shopping(item : String, id : String) {

        val query : HashMap<String, String> = HashMap()
        query["list"] = item
        query["id"] = id

        viewModelScope.launch {
            val response = RetrofitBuilder.api.getStore(query)
            if(response.isSuccessful) {
                _shopping_result.value = response.body()!!.result
                _coin.value = response.body()!!.coin
                _no_clean.value = response.body()!!.user_no_clean
                _choose_sit.value = response.body()!!.user_sit
                _outside.value = response.body()!!.user_outside
            }
        }
    }

}