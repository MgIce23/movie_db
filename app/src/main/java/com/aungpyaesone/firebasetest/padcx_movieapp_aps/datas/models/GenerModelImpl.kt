package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieWithGenerVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.API_KEY
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.EN_ERROR_MESSAGE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object GenerModelImpl : BaseModel(),GenerListModel {

    @SuppressLint("CheckResult")
    override fun getGenersListFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mClientApi.getGenerList(API_KEY)
            .map { it.generlist.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.generDao().insertGenerList(it)
            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    @SuppressLint("CheckResult")
    override fun getMovieWithGereFromApiSaveToDB(gener:String, onSuccess: (List<MovieWithGenerVO>) -> Unit, onError: (String) -> Unit) {
        mClientApi.getWithGenerList(API_KEY,gener).map {
            it?.let{
                it
            }
        }.subscribeOn(Schedulers.io())
            .map { it.result.toList() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let{onSuccess(it)}
           //     mTheDB.movieGenerDao().insertMovieWithGenerList(it)
            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)})
    }

    override fun getMovieWithGenerList(): LiveData<List<MovieWithGenerVO>> {
       return mTheDB.movieGenerDao().getAllMovies()
    }

    override fun getAllGenerList(onError: (String) -> Unit): LiveData<List<GenersVO>> {
      return mTheDB.generDao().getAllGener()
    }
}