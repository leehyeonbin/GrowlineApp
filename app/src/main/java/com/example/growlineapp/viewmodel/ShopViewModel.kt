package com.example.growlineapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.growlineapp.data.retrofit.RetrofitBuilder
import kotlinx.coroutines.launch

class ShopViewModel: ViewModel() {

    private val _result = MutableLiveData<String>()
    val result : LiveData<String>
        get() = _result



    fun shopping(item : String) {

        val query : HashMap<String, String> = HashMap()
        query["item"] = item

        viewModelScope.launch {
            val response = RetrofitBuilder.api.getStore(query)
            if(response.isSuccessful) {
                _result.value = response.body()!!.result
            }
        }
    }
}