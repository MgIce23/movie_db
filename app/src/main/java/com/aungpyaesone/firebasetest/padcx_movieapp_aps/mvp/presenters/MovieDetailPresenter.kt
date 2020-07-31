package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieDetailView

interface MovieDetailPresenter : BasePresenter<MovieDetailView> {
    fun onUiReady(movieId:Int,lifecycleOwner: LifecycleOwner)
}