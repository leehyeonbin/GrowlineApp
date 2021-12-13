package com.example.growlineapp.view.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun init() {
        initBottomNavBar()
    }


    private fun initBottomNavBar() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_view) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(mBinding.bottomNavView, navController)
    }
}