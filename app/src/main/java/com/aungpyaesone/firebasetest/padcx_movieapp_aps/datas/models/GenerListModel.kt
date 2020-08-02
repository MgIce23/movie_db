package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieWithGenerVO

interface GenerListModel {
    fun getGenersListFromApiSaveToDB(onSuccess:()->Unit,onError:(String) ->Unit)

    fun getMovieWithGereFromApiSaveToDB(gener:String,onSuccess: () -> Unit,onError: (String) -> Unit)

    fun getMovieWithGenerList():LiveData<List<MovieWithGenerVO>>

    fun getAllGenerList(onError: (String) -> Unit):LiveData<List<GenersVO>>
}