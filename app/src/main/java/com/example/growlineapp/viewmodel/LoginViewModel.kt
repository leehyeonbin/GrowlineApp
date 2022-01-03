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

class LoginViewModel : ViewModel() {

    private val TAG = "LoginViewModel - TAG"

    private var _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result


    fun loginCheck(input_id: String, input_password: String) {

        Log.d(TAG, input_id + " " + input_password)

        val queries: HashMap<String, String> = HashMap()

        queries["user_id"] = input_id
        queries["password"] = input_password

        Log.d(TAG, "loginCheck 함수 실행")

        viewModelScope.launch {
            val response = RetrofitBuilder.api.loginCheck(queries)
            Log.d(TAG, "retrofit 실행")

            if (response.isSuccessful) {
                Log.d(TAG, response.body()!!.result)
                _result.value = response.body()?.result
            }
            else {
                Log.d(TAG, "retrofit 통신 오류")
            }
        }
//        CoroutineScope(Dispatchers.IO).launch {
//            RetrofitBuilder.api.loginCheck(queries).enqueue(object : retrofit2.Callback<LoginResult> {
//                override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {
//                    if (response.isSuccessful) {
//                        val resultInfo = response.body()
//                        _result.value = resultInfo?.result.toString()
//                        Log.d(TAG, "통신 성공")
//                    }
//                }
//
//                override fun onFailure(call: Call<LoginResult>, t: Throwable) {
//                    Log.d(TAG, t.toString())
//                }
//            })
//        }
    }
}