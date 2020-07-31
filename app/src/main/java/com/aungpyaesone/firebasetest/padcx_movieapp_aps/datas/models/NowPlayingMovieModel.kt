package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.NowPlayingVO

interface NowPlayingMovieModel {

    fun getAllNowPlayingMovieFromApiSaveToDatabase(onSuccess: ()->Unit,
    onFailure:(String)->Unit)

    fun getAllNowPlayingMovieList(onError:(String) ->Unit): LiveData<List<NowPlayingVO>>
}