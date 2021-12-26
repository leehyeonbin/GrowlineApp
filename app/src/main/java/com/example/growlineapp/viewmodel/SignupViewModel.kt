package com.example.growlineapp.viewmodel

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

class SignupViewModel : ViewModel() {

    private val TAG = "SignUpViewModel - TAG"

    private val _result = MutableLiveData<Boolean>()
    val result : LiveData<Boolean>
        get() = _result

    fun signup (user_id : String, user_password : String) {
        val querys : HashMap<String, String> = HashMap()
        querys["user_id"] = user_id
        querys["user_password"] = user_password

        CoroutineScope(Dispatchers.IO).launch {
            RetrofitBuilder.api.signUp(querys).enqueue(object : retrofit2.Callback<LoginResult> {
                override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
                    if (response.isSuccessful) {
                        _result.value = response.body()?.result
                    }
                }

                override fun onFailure(call: Call<LoginResult>, t: Throwable) {
                    Log.e(TAG,t.message.toString())
                }

            })
        }
    }

}