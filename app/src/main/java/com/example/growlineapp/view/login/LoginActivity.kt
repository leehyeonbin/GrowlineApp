package com.example.growlineapp.view.login

import android.content.Intent
import android.os.Bundle
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivityLoginBinding
import com.example.growlineapp.view.main.MainActivity

class LoginActivity : BaseActivity() {

    private lateinit var mBinding : ActivityLoginBinding
    override fun init() {
        click_Button()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()

    }

    private fun click_Button() {
        mBinding.submitBtn.setOnClickListener {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    }
}