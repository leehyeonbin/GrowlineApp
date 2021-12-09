package com.example.growlineapp.view.main

import android.os.Bundle
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var mBinding : ActivityMainBinding
    override fun init() {
        initBottomNavBar()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    private fun initBottomNavBar() {

    }
}