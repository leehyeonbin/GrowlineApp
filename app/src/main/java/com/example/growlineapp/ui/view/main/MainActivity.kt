package com.example.growlineapp.ui.view.main

import android.view.View
import androidx.activity.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseActivity
import com.example.growlineapp.databinding.ActivityMainBinding
import com.example.growlineapp.ui.view.main.fragment.noticeboard.PostFragment
import com.example.growlineapp.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()

    private val postFragment = PostFragment()


    override fun init() {
        initBottomNavBar()
        observeViewModel()
    }


//    private fun initBottomNavBar() {
//        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_view) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        NavigationUI.setupWithNavController(mBinding.bottomNavView, navController)
//    }

    private fun initBottomNavBar() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.fragment_view)?.findNavController()
        val nav = mBinding.bottomNavView as BottomNavigationView
        navController?.let {
            nav.setupWithNavController(navController)
        }
    }

/*    fun onFragment(int: Int) {
        val transition = supportFragmentManager.beginTransaction()
        when(int){
            1->transition.replace(R.id.fragment_view, postFragment)
        }
        transition.commit()
    }*/


    private fun observeViewModel() {
        mainViewModel.eventActionView.observe(this,
            {
                when(it) {
                    true -> mBinding.bottomNavView.visibility = View.VISIBLE
                    false -> mBinding.bottomNavView.visibility = View.GONE
                }
            })
    }
}