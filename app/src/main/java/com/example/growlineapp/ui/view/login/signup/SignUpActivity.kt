package com.example.growlineapp.ui.view.login.signup

import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivitySignUpBinding
import com.example.growlineapp.ui.view.login.LoginActivity
import com.example.growlineapp.viewmodel.SignupViewModel
import kotlinx.coroutines.delay

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private val signUpViewModel by viewModels<SignupViewModel>()
    private val TAG ="SignUpActivity - TAG"

    override fun init() {
        click_btn()
        clickBackBtn()
    }

    private fun clickBackBtn() {
        mBinding.backBtn.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
            finish()
        }
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
            signUpViewModel.signup(mBinding.signupIdEt.text.toString(), mBinding.signupPasswordEt.text.toString())
            Log.d(TAG, signUpViewModel.result.value.toString())
            signUpViewModel.result.observe(this, {
                if (signUpViewModel.result.value == "true") {
                    shortShowToast("회원가입 되었습니다.")
                    startActivity(Intent(this,LoginActivity::class.java))
                    finish()
                }
                else {
                    shortShowToast("아이디가 중복됩니다.")
                }
            })
        }
        else {
            longShowToast("비밀번호가 다릅니다.")
        }
    }

}