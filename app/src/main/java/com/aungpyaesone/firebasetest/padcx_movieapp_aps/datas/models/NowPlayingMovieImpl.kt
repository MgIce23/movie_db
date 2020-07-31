package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.NowPlayingVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.API_KEY
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.EN_ERROR_MESSAGE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object NowPlayingMovieImpl : BaseModel(),NowPlayingMovieModel {
    @SuppressLint("CheckResult")
    override fun getAllNowPlayingMovieFromApiSaveToDatabase(
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
       mClientApi.getNowPlayingMovie(API_KEY)
           .map {
               it?.result.toList() }
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
               mTheDB.nowPlayingDao().insertNowPlayingMovieList(it)
           },{
               onFailure(it.localizedMessage ?: EN_ERROR_MESSAGE)
           })
    }

    override fun getAllNowPlayingMovieList(onError:(String) ->Unit): LiveData<List<NowPlayingVO>> {
        return mTheDB.nowPlayingDao().getAllNowPlaying()
    }
}