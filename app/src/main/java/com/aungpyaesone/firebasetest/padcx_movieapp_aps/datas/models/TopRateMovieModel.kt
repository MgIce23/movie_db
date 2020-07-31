package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.TopRatedVO

interface TopRateMovieModel  {
    fun getTopMovieFromApiSaveToDB(onSuccess:()->Unit,onError:(String) ->Unit)

    fun getAllTopMovieList(onError: (String) -> Unit) : LiveData<List<TopRatedVO>>
}