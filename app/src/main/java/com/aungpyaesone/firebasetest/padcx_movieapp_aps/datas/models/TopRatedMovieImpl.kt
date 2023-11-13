package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.BuildConfig
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.TopRatedVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.utils.API_KEY
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.utils.EN_ERROR_MESSAGE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object TopRatedMovieImpl : BaseModel(),TopRateMovieModel {
    @SuppressLint("CheckResult")
    override fun getTopMovieFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mClientApi.getTopRatedMovies(API_KEY)
            .map { it.result.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.topRateMovieDao().insertTopRateMovieList(it)
            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    override fun getAllTopMovieList(onError: (String) -> Unit): LiveData<List<TopRatedVO>> {
       return mTheDB.topRateMovieDao().getAllTopRateMovie()
    }
}