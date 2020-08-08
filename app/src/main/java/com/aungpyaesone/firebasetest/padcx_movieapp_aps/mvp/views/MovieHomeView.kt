package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.*
import com.example.shared.mvp.views.BaseView

interface MovieHomeView : BaseView {

    fun showPopularMovie(popularMovie:List<PopularMovieVO>)

    fun showNowPlayingMovieList(upComingMovie:List<NowPlayingVO>)

    fun showPopularPeopleList(popularPeople:List<PeopleVO>)

    fun showPosterList(posterList: List<PopularMovieVO>)

    fun navigateToDetail(id: Int)

    fun navigateToMovieDetail(id:Int)

    fun sendGenerList(generList:List<GenersVO>)

}