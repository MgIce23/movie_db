package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieWithGenerVO
import com.example.shared.mvp.views.BaseView

interface TopRatedMovieView : BaseView {
    fun showTopRatedMovieList(topMovieList: List<MovieWithGenerVO>)

    fun navigateToDetailScreen(id:Int)
}