package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.mockmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.getPopularMovies
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.GenerListModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieWithGenerVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

object GenerListMockModelImpl : GenerListModel {
    override fun getGenersListFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {

    }

    override fun getMovieWithGereFromApiSaveToDB(
        gener: String,
        onSuccess: (List<MovieWithGenerVO>) -> Unit,
        onError: (String) -> Unit
    ) {

    }


    override fun getMovieWithGenerList(): LiveData<List<MovieWithGenerVO>> {
        val liveData = MutableLiveData<List<MovieWithGenerVO>>()
     //   liveData.postValue(getPopularMovies())
        return liveData
    }

    override fun getAllGenerList(onError: (String) -> Unit): LiveData<List<GenersVO>> {
        val liveData = MutableLiveData<List<GenersVO>>()
      //  liveData.postValue(getPopularMovies())
        return liveData
    }
}