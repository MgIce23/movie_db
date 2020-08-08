package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieDetailView
import com.example.shared.mvp.presenters.BasePresenter

interface MovieDetailPresenter : BasePresenter<MovieDetailView> {
    fun onUiReady(movieId:Int,lifecycleOwner: LifecycleOwner)
}