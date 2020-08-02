package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.mockmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.getPopularMovies
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.PopularMovieModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieResultVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

object PopularMockkModel : PopularMovieModel {
    var popularMovie : MutableList<PopularMovieVO> = arrayListOf()
    var popularMoveLiveData = MutableLiveData<List<PopularMovieVO>>()

    override fun getAllPopularMovieFromApiSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllPopularMovieList(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
        val liveData = MutableLiveData<List<PopularMovieVO>>()
        liveData.postValue(getPopularMovies())
        return liveData
    }

    override fun getPosterPath(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
        val liveData = MutableLiveData<List<PopularMovieVO>>()
       // liveData.postValue(getPopularMovies())
        return liveData
    }

    override fun getVideoFromApi(
        movieId: Int,
        onSuccess: (List<MovieResultVO>) -> Unit,
        onError: (String) -> Unit
    ) {

    }


}