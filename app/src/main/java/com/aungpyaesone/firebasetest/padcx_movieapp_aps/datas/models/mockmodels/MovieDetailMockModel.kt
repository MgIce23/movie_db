package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.mockmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.getMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.MovieDetailModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CastAndCrewVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieWithGenerVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO

object MovieDetailMockModel : MovieDetailModel {
    override fun getMovieDetailsAndSaveToDatabase(
        id: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getMovieDetails(id: Int, onError: (String) -> Unit): LiveData<MovieVO> {
        val liveData = MutableLiveData<MovieVO>()
        liveData.postValue(getMovieVO())
        return liveData
    }

    override fun getAllPopularPeople(onError: (String) -> Unit): LiveData<List<PeopleVO>> {
        val liveData = MutableLiveData<List<PeopleVO>>()
        //liveData.postValue(getMovieVO())
        return liveData
    }

    override fun getAllCastAndCrewFromApiSaveDataBase(
        id: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getAllCastAndCrew(id: Int, onError: (String) -> Unit): LiveData<CastAndCrewVO> {
        val liveData = MutableLiveData<CastAndCrewVO>()
        //liveData.postValue(getMovieVO())
        return liveData
    }
}