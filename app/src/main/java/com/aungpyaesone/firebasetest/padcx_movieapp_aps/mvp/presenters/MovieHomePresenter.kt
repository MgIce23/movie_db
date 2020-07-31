package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.ItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.PopularMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.TopRatedMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieHomeView

interface MovieHomePresenter : BasePresenter<MovieHomeView>,ItemDelegate,TopRatedMovieItemDelegate {

    fun onUiReady(lifecycleOwner: LifecycleOwner)
}