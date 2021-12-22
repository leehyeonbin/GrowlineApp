package com.example.growlineapp.ui.view.main.fragment.noticeboard

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseFragment
import com.example.growlineapp.databinding.FragmentNoticeboardBinding
import com.example.growlineapp.ui.view.main.MainActivity
import com.example.growlineapp.viewmodel.MainViewModel

class NoticeboardFragment : BaseFragment<FragmentNoticeboardBinding>(R.layout.fragment_noticeboard){

    private var mainActivity: MainActivity? = null
    private val mainViewModel by viewModels<MainViewModel>()


    override fun init() {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.postBtn.setOnClickListener {
            mainViewModel.setActionView(false)
            this.findNavController().navigate(R.id.action_noticeboardFragment_to_postFragment)

        }
    }

}