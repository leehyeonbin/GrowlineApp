package com.example.growlineapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.growlineapp.data.model.LoginResult
import com.example.growlineapp.data.retrofit.RetrofitBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class SignupViewModel : ViewModel() {

    private val TAG = "SignUpViewModel - TAG"

    private val _result = MutableLiveData<String>()
    val result : LiveData<String>
        get() = _result

    fun signup (user_id : String, user_password : String) {
        val queriys : HashMap<String, String> = HashMap()
        queriys["user_id"] = user_id
        queriys["password"] = user_password


        viewModelScope.launch {
            val response = RetrofitBuilder.api.signUp(queriys)

            if(response.isSuccessful) {
                Log.d(TAG, response.body()!!.result)
                _result.value = response.body()!!.result
            }
        }
    }

}