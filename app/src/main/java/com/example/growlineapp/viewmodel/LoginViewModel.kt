package com.example.growlineapp.viewmodel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.growlineapp.data.model.LoginResult
import com.example.growlineapp.data.retrofit.RetrofitBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

@Suppress("UnusedEquals")
class LoginViewModel() : ViewModel(){

    private val TAG = "LoginViewModel - TAG"

    private var _result = MutableLiveData<Boolean>()
    val result : LiveData<Boolean>
    get() = _result

    fun loginCheck(input_id : String, input_password : String) {

        val queries: HashMap<String, String> = HashMap()

        queries["user_id"] = input_id
        queries["user_password"] = input_password

        CoroutineScope(Dispatchers.IO).launch {
            RetrofitBuilder.api.loginCheck(queries).equals(object : retrofit2.Callback<LoginResult> {
                override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                    if (response.isSuccessful) {
                        _result.value = response.body()?.result
                    }
                }

                override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                    Log.e(TAG, t.toString())
                }

            })
        }
    }
}