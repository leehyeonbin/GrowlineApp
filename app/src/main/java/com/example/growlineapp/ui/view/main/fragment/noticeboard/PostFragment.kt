package com.example.growlineapp.ui.view.main.fragment.noticeboard

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseFragment
import com.example.growlineapp.databinding.FragmentPostBinding
import com.example.growlineapp.ui.view.main.MainActivity
import com.example.growlineapp.viewmodel.MainViewModel

class PostFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post) {

    private val mainViewModel by viewModels<MainViewModel>()
    private var mainActivity : MainActivity? = null
    private val TAG = "PostFragment - TAG"

    override fun init() {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            submitBtn.setOnClickListener {
                onPostingBtn()
            }

            backBtn.setOnClickListener {
                onBackBtn()
            }
        }
    }

    private fun onPostingBtn() {
        mainViewModel.setActionView(true)
        this.findNavController().navigate(R.id.action_postFragment_to_noticeboardFragment)
        Log.d(TAG, "Onclick_post")

    }

    private fun onBackBtn() {
        mainViewModel.setActionView(true)
        this.findNavController().navigate(R.id.action_postFragment_to_noticeboardFragment)
    }
}