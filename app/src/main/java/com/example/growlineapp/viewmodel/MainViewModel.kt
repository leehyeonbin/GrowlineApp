package com.example.growlineapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.growlineapp.data.model.Post_list
import com.example.growlineapp.data.model.UserProfile
import com.example.growlineapp.data.retrofit.RetrofitBuilder
import com.example.growlineapp.ui.adapter.PostRecyclerViewAdapter
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

    private var _userId = MutableLiveData<String>()
    val userId : LiveData<String>
        get() = _userId

    fun setActionView(content: Boolean) {
        _eventActionView.value = content
    }


    fun setUserId(user_id : String) {
        _userId.value = user_id
    }


    fun getUserInfo(input_id:String) {
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

    fun getPostList() {
        CoroutineScope(Dispatchers.IO).launch {
            RetrofitBuilder.api.getPostList().enqueue(object : retrofit2.Callback<Post_list> {
                override fun onResponse(call: Call<Post_list>, response: Response<Post_list>) {
                    if(response.isSuccessful) {
                        val post_list = response.body()
                        PostRecyclerViewAdapter(post_list!!.post)
                    }
                }

                override fun onFailure(call: Call<Post_list>, t: Throwable) {
                    Log.d(TAG, "게시글 불러오기 실패 : " + t.message.toString())
                }

            })
        }
    }

}