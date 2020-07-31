package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.TopRatedVO

interface TopRatedMovieView : BaseView{
    fun showTopRatedMovieList(topMovieList: List<TopRatedVO>)

    fun navigateToDetailScreen(id:Int)
}