package com.example.growlineapp.ui.view.login

import android.content.Intent
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivityLoginBinding
import com.example.growlineapp.ui.view.login.signup.SignUpActivity
import com.example.growlineapp.ui.view.main.MainActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun init() {
        click_signUp()
        click_Button()
    }

    private fun click_signUp() {
        mBinding.signupTv.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            finish()
        }
    }


    private fun click_Button() {
        mBinding.submitBtn.setOnClickListener {
            check_et()
        }
    }

    fun check_et() {
        if (mBinding.loginIdEt.text.isEmpty() || mBinding.loginPasswordEt.text.isEmpty()) {
            longShowToast("아이디와 비밀번호를 모두 입력해주세요.")
        }
        else {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    }
}