package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.ItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.PopularMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.TopRatedMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieHomeView
import com.example.shared.mvp.presenters.BasePresenter

interface MovieHomePresenter : BasePresenter<MovieHomeView>,ItemDelegate, PopularMovieItemDelegate,TopRatedMovieItemDelegate {

    fun onUiReady(lifecycleOwner: LifecycleOwner)
}