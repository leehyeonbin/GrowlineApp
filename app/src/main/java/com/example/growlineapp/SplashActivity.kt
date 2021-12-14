package com.example.growlineapp

import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    private val appVersion = "1.0.0"

    override fun init() {
        checkVersion()
    }

    private fun checkVersion() {
        if (appVersion =="0.0.0") {
            longShowToast("점검중 입니다.")
        }
    }
}