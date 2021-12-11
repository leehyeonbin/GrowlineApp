package com.example.growlineapp.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.growlineapp.base.BaseFragment
import com.example.growlineapp.databinding.FragmentNoticeboardBinding


class noticeboardFragment : BaseFragment() {

    private var mBinding : FragmentNoticeboardBinding? = null

    override fun init() {

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentNoticeboardBinding.inflate(inflater, container, false)
        return mBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}