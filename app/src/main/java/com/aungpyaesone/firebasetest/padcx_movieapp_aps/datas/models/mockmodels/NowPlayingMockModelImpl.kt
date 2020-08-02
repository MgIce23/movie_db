package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.mockmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.getNowPlayingDummy
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.getPopularMovies
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.NowPlayingMovieModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.NowPlayingVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

object NowPlayingMockModelImpl : NowPlayingMovieModel {
    override fun getAllNowPlayingMovieFromApiSaveToDatabase(
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

    }

    override fun getAllNowPlayingMovieList(onError: (String) -> Unit): LiveData<List<NowPlayingVO>> {
        val liveData = MutableLiveData<List<NowPlayingVO>>()
        liveData.postValue(getNowPlayingDummy())
        return liveData
    }
}