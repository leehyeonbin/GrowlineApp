package com.example.growlineapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivitySplashBinding
import com.example.growlineapp.view.login.LoginActivity

class SplashActivity : BaseActivity() {

    private lateinit var mBinding : ActivitySplashBinding
    private val appVersion = "1.0.0"

    override fun init() {
        if (appVersion =="0.0.0") {
            longShowToast("점검중 입니다.")
        }
        else {
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}