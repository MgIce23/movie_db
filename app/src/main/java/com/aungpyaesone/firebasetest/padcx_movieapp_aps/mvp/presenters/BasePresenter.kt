package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters

import android.view.View
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.BaseView

interface BasePresenter<T:BaseView> {
    fun initPresenter(view: T)
}