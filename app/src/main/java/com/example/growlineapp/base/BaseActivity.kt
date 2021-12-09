package com.example.growlineapp.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){
    abstract fun init()

    protected fun shortShowToast(msg : String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun longShowToast(msg : String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}