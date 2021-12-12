package com.example.growlineapp.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.growlineapp.base.BaseFragment
import com.example.growlineapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment(){

    private var mBinding : FragmentHomeBinding? = null

    override fun init() {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}