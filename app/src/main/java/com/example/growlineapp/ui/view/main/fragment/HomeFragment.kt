package com.example.growlineapp.ui.view.main.fragment

import android.content.Intent
import android.net.Uri
import com.example.growlineapp.R
import com.example.growlineapp.base.BaseFragment
import com.example.growlineapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home){

    override fun init() {
        setOnclickButton()
    }


    private fun setOnclickButton () {
        binding.apply {
            appInfoBtn.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.notion.so/0ed7b7b558e94b549c1fc63dbc4e0768") ))
            }
            howCoinBtn.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.notion.so/fe0845c7d1ab47089d6777559158e144")))
            }
        }
    }

}