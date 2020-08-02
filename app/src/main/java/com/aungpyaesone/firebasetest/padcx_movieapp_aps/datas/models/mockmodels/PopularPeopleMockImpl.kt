package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.mockmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.getPopularMovies
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.PopularPeopleModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

object PopularPeopleMockImpl : PopularPeopleModel {
    override fun getPopularPeopleFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {

    }

    override fun getAllPeoplePoster(onError: (String) -> Unit): LiveData<List<PeopleVO>> {
        val liveData = MutableLiveData<List<PeopleVO>>()
      //  liveData.postValue(getPopularMovies())
        return liveData
    }
}