package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.TopRatedMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.TopRatedMovieView
import com.example.shared.mvp.presenters.BasePresenter

interface TopRatedMoviePresenter : BasePresenter<TopRatedMovieView>,TopRatedMovieItemDelegate {
    fun onUiReady(gener:String,lifecycleOwner: LifecycleOwner)
}