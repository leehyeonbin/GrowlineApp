package com.example.growlineapp.ui.view.main.fragment.mypage

import androidx.fragment.app.activityViewModels
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseFragment
import com.example.growlineapp.databinding.FragmentProfileBinding
import com.example.growlineapp.viewmodel.MainViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    private val mainVieweModel by activityViewModels<MainViewModel>()

    override fun init() {
        loadUserInfo()
    }

    private fun loadUserInfo() {
        mainVieweModel.getUserInfo()
    }

    private fun ClickMyPost() {

    }



}