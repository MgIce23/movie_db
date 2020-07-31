package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.NowPlayingVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

interface MovieHomeView : BaseView {

    fun showPopularMovie(popularMovie:List<PopularMovieVO>)

    fun showNowPlayingMovieList(upComingMovie:List<NowPlayingVO>)

    fun showPopularPeopleList(popularPeople:List<PeopleVO>)

    fun showPosterList(posterList: List<PopularMovieVO>)

    fun navigateToDetail(id: Int)

}