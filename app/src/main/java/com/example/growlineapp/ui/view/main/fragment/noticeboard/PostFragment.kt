package com.example.growlineapp.ui.view.main.fragment.noticeboard

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseFragment
import com.example.growlineapp.databinding.FragmentPostBinding
import com.example.growlineapp.ui.view.main.MainActivity

class PostFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post) {

    private var mainActivity : MainActivity? = null

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

    }

    private fun onBackBtn() {

    }
}