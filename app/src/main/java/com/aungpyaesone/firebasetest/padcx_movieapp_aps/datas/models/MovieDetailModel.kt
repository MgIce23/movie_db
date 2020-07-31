package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

interface MovieDetailModel {
    fun getMovieDetailsAndSaveToDatabase(id:Int,onSuccess: ()->Unit,onError: (String)->Unit)

    fun getMovieDetails(id: Int,onError: (String) -> Unit): LiveData<MovieVO>

    fun getAllPopularPeople(onError: (String) -> Unit): LiveData<List<PeopleVO>>
}