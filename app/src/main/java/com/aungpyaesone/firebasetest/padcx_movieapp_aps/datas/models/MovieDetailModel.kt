package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.*

interface MovieDetailModel {
    fun getMovieDetailsAndSaveToDatabase(id:Int,onSuccess: ()->Unit,onError: (String)->Unit)

    fun getMovieDetails(id: Int,onError: (String) -> Unit): LiveData<MovieVO>

    fun getAllPopularPeople(onError: (String) -> Unit): LiveData<List<PeopleVO>>

    fun getAllCastAndCrewFromApiSaveDataBase(id:Int,onSuccess:()->Unit,onError:(String)->Unit)

    fun getAllCastAndCrew(id: Int,onError: (String) -> Unit): LiveData<CastAndCrewVO>

}