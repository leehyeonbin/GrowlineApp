package com.example.growlineapp.base

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val layoutResId : Int) : AppCompatActivity(){
    protected lateinit var mBinding : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, layoutResId)
        init()
    }

    abstract fun init()

    protected fun shortShowToast(msg : String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun longShowToast(msg : String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


}