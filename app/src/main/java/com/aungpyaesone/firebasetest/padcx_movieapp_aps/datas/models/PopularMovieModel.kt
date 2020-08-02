package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieResultVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

interface PopularMovieModel {
    fun getAllPopularMovieFromApiSaveToDatabase(onSuccess:()->Unit,onError:(String)->Unit)

    fun getAllPopularMovieList(onError: (String) -> Unit): LiveData<List<PopularMovieVO>>

    fun getPosterPath(onError: (String) -> Unit):LiveData<List<PopularMovieVO>>

    fun getVideoFromApi(movieId: Int,onSuccess:(List<MovieResultVO>)->Unit,onError: (String) -> Unit)
}