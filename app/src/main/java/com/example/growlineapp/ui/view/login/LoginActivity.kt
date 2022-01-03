package com.example.growlineapp.ui.view.login

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivityLoginBinding
import com.example.growlineapp.ui.view.login.signup.SignUpActivity
import com.example.growlineapp.ui.view.main.MainActivity
import com.example.growlineapp.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private val loginViewModel by viewModels<LoginViewModel>()
    private val TAG = "LoginActivity TAG"

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
            Log.d(TAG,mBinding.loginIdEt.text.toString() + " " + mBinding.loginPasswordEt.text.toString())
        }
    }

    private fun check_et() {
        if (mBinding.loginIdEt.text.isEmpty() || mBinding.loginPasswordEt.text.isEmpty()) {
            longShowToast("아이디와 비밀번호를 모두 입력해주세요.")
        }
        else {
            login_checking(mBinding.loginIdEt.text.trim().toString(), mBinding.loginPasswordEt.text.trim().toString())
        }
    }

    private fun login_checking(id: String, password: String) {
        mBinding.progressbar.visibility = View.VISIBLE
        loginViewModel.loginCheck(id, password)
        loginViewModel.result.observe(this,{
            if (loginViewModel.result.value == "true") {
                mBinding.progressbar.visibility = View.GONE
                longShowToast("환영합니다.")
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("user_id", id)
                startActivity(intent)
                finish()
            }

            else if (loginViewModel.result.value == "false"){
                shortShowToast("아이디 또는 비밀번호를 확인해주세요.")
                mBinding.progressbar.visibility = View.GONE
            }
        })
    }


}