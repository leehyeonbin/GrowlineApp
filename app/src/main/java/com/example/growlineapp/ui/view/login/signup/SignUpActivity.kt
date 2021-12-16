package com.example.growlineapp.ui.view.login.signup

import android.content.Intent
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivitySignUpBinding
import com.example.growlineapp.ui.view.login.LoginActivity

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun init() {
        click_btn()
    }

    private fun click_btn() {
        mBinding.submitBtn.setOnClickListener {
            check_et()
        }
    }

    private fun check_et() {
        if(mBinding.signupIdEt.text.isEmpty() || mBinding.signupPasswordEt.text.isEmpty()) {
            longShowToast("아이디와 비밀번호를 입력해주세요.")
        }
        else {
            check_password()
        }
    }

    private fun check_password() {
        if(mBinding.signupPasswordEt.text.toString() == mBinding.signupCheckEt.text.toString()) {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
        else {
            longShowToast("비밀번호가 다릅니다.")
        }
    }

}