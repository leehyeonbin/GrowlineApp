package com.example.growlineapp

import android.os.Bundle
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {

    private lateinit var mBinding : ActivitySplashBinding
    private val appVersion = "1.0.0"

    override fun init() {
        checkVersion()
    }

    private fun checkVersion() {
        if (appVersion =="0.0.0") {
            longShowToast("점검중 입니다.")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}