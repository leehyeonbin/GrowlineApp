package com.example.growlineapp.view.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {

    private lateinit var mBinding : ActivityLoginBinding
    override fun init() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}