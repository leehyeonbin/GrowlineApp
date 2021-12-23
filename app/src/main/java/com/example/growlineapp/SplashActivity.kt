package com.example.growlineapp

import android.content.Intent
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivitySplashBinding
import com.example.growlineapp.ui.view.main.MainActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    private val appVersion = "1.0.0"

    override fun init() {
        checkVersion()
    }

    private fun checkVersion() {
        if (appVersion =="0.0.0") {
            longShowToast("점검중 입니다.")
        }
        else {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}