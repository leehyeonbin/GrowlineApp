package com.example.growlineapp.ui.view.main.fragment.mypage

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseFragment
import com.example.growlineapp.databinding.FragmentProfileBinding
import com.example.growlineapp.ui.view.main.MainActivity
import com.example.growlineapp.viewmodel.MainViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    private val mainViewModel by activityViewModels<MainViewModel>()
    private var mainActivity : MainActivity? = null


    override fun init() {
        observeUserInfo()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.showPostBtn.setOnClickListener {
            clickMyPost()
        }
    }

    private fun clickMyPost() {
        shortShowText("준비중 입니다.")
//        this.findNavController().navigate(R.id.action_profileFragment_to_myPostFragment)
    }

    private fun observeUserInfo() {
        mainViewModel.userInfo_result.observe(this,{
            binding.userNameTv.text = mainViewModel.userName.value
            binding.userNoClean.text = mainViewModel.no_clean.value.toString()
            binding.userOutside.text = mainViewModel.outside.value.toString()
            binding.userSit.text = mainViewModel.choose_sit.value.toString()
            binding.progressbar.visibility = View.GONE
        })
    }

}