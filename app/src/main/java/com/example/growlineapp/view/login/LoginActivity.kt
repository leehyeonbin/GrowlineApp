package com.example.growlineapp.view.login

import android.content.Intent
import android.os.Bundle
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivityLoginBinding
import com.example.growlineapp.view.main.MainActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun init() {
        click_Button()
    }


    private fun click_Button() {
        mBinding.submitBtn.setOnClickListener {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    }
}