package com.example.growlineapp.ui.view.main

import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivityMainBinding
import com.example.growlineapp.ui.view.main.fragment.noticeboard.PostFragment
import com.example.growlineapp.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()

    private val postFragment = PostFragment()

    override fun init() {
        initBottomNavBar()
    }


    private fun initBottomNavBar() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_view) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(mBinding.bottomNavView, navController)
    }

    fun onFragment(int: Int) {
        val transition = supportFragmentManager.beginTransaction()
        when(int){
            1->transition.replace(R.id.fragment_view, postFragment)
        }
        transition.commit()
    }
}