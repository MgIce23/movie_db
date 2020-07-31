package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters

import androidx.lifecycle.ViewModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.BaseView

abstract class AbstractBasePresenter<T:BaseView> : BasePresenter<T>,ViewModel(){
    var mView : T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}