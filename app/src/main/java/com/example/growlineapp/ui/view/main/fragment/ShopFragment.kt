package com.example.growlineapp.ui.view.main.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseFragment
import com.example.growlineapp.databinding.FragmentShopBinding
import com.example.growlineapp.viewmodel.ShopViewModel

class ShopFragment : BaseFragment<FragmentShopBinding>(R.layout.fragment_shop){

    private val shopViewModel by activityViewModels<ShopViewModel>()
    private val TAG = "ShopFragment - TAG"

    override fun init() {
        onClickListener()
        observeResult()
    }


    private fun onClickListener() {
        binding.goingOutTv.setOnClickListener {
            Log.d(TAG, "going out")
            shopViewModel.shopping("1")
        }
        binding.cleaningPassTv.setOnClickListener {
            Log.d(TAG, "Cleaning pass")
            shopViewModel.shopping("2")
        }
        binding.firstSitTv.setOnClickListener {
            Log.d(TAG, "first sitting")
            shopViewModel.shopping("3")
        }
    }

    private fun observeResult() {
        shopViewModel.result.observe(this,{
            if(shopViewModel.result.value == "true") {
                shortShowText("구매 성공")
            }
            else if(shopViewModel.result.value == "false") {
                shortShowText("잔액 부족")
            }
        })
    }

}