package com.example.growlineapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.growlineapp.data.model.UserProfile
import com.example.growlineapp.data.retrofit.RetrofitBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel() {
    //다른화면으로 넘어갈때 bottom nav bar 숨기기 or 보이기 (true = 보이기, false = 숨기기)


    private val _eventActionView = MutableLiveData(true)
    val eventActionView: LiveData<Boolean> get() = _eventActionView
    private val TAG = "MainViewModel - TAG"


    private var _id = MutableLiveData<String>()
    val id : LiveData<String>
        get() = _id

    private var _summary  = MutableLiveData<String>()
    val summary : LiveData<String>
        get() = _summary

    private var _koin = MutableLiveData<Int>()
    val koin : LiveData<Int>
        get() = _koin

    fun setActionView(content: Boolean) {
        _eventActionView.value = content
    }




    fun getUserInfo(input_id:String, input_password : String) {
        val queries: HashMap<String, String> = HashMap()

        queries["user_id"] = input_id

        CoroutineScope(Dispatchers.IO).launch {
            RetrofitBuilder.api.getUserProfile(queries).enqueue(object : retrofit2.Callback<UserProfile> {
                override fun onResponse(call: Call<UserProfile>, response: Response<UserProfile>) {
                    if (response.isSuccessful) {
                        if(response.body()!!.login_result) {
                            val profile = response.body()
                            _id.value = profile?.user_id
                            _summary.value = profile?.user_summary
                            _koin.value = profile?.user_koin
                        }
                    }
                }

                override fun onFailure(call: Call<UserProfile>, t: Throwable) {
                    Log.e(TAG,t.toString())
                }

            })
        }
    }

}