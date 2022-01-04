package com.example.growlineapp.ui.view.main.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseFragment
import com.example.growlineapp.databinding.FragmentShopBinding
import com.example.growlineapp.viewmodel.MainViewModel

class ShopFragment : BaseFragment<FragmentShopBinding>(R.layout.fragment_shop){

    private val mainViewModel by activityViewModels<MainViewModel>()
    private val TAG = "ShopFragment - TAG"

    override fun init() {
        onClickListener()
        initCoin()
        observeResult()
//        observeShopping()
    }

    private fun initCoin() {
        mainViewModel.coin.observe(this, {
            binding.userCoin.text = mainViewModel.coin.value.toString()
        })
    }




    private fun onClickListener() {
        binding.goingOutTv.setOnClickListener {
            Log.d(TAG, "going out")
            mainViewModel.shopping("outside", "gsm")
        }
        binding.cleaningPassTv.setOnClickListener {
            Log.d(TAG, "Cleaning pass")
            mainViewModel.shopping("no_clean", "gsm")
        }
        binding.firstSitTv.setOnClickListener {
            Log.d(TAG, "first sitting")
            mainViewModel.shopping("choose_sit", "gsm")
        }
    }

    private fun observeResult() {
        mainViewModel.shopping_result.observe(this,{
            if(mainViewModel.shopping_result.value == "true") {
                shortShowText("구매 성공")
            }
            else if(mainViewModel.shopping_result.value == "false") {
                shortShowText("잔액 부족")
            }
        })
    }

//    private fun observeShopping() {
//        mainViewModel.coin.observe(this, {
//            binding.userCoin.text = mainViewModel.coin.value.toString()
//            binding.firstSitTv.text = mainViewModel.choose_sit.value.toString()
//            binding.cleaningPassTv.text = mainViewModel.no_clean.value.toString()
//            binding.goingOutTv.text = mainViewModel.outside.value.toString()
//        })
//    }
}