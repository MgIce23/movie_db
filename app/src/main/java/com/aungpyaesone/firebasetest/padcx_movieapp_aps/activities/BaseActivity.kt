package com.aungpyaesone.firebasetest.padcx_movieapp_aps.activities

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity(){

    protected fun showSnackBar(message: String){
        Snackbar.make(window.decorView,message,Snackbar.LENGTH_SHORT).show()
    }

}