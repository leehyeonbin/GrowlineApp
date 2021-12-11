package com.example.growlineapp.base

import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract fun init()

    protected fun shortShowText (msg : String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    protected fun longShowtext (msg : String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}