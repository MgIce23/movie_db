package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.BuildConfig
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieResultVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.EN_ERROR_MESSAGE
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PopularMovieImpl : BaseModel(),PopularMovieModel {
    @SuppressLint("CheckResult")
    override fun getAllPopularMovieFromApiSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mClientApi.getPopularMovies(BuildConfig.MY_API_KEY)
            .map {
                it.result.toList() ?: listOf()
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.moviesDao().insertPopularMovieList(it)
            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    override fun getAllPopularMovieList(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
        return mTheDB.moviesDao().getAllPopular()
    }

    override fun getPosterPath(onError: (String) -> Unit): LiveData<List<PopularMovieVO>> {
        return mTheDB.moviesDao().getPosterPath()
    }

    @SuppressLint("CheckResult")
    override fun getVideoFromApi(movieId:Int, onSuccess: (List<MovieResultVO>) -> Unit, onError: (String) -> Unit) {
        mClientApi.getVideo(movieId,BuildConfig.MY_API_KEY).map {
            it.result.toList()
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.let { onSuccess(it) }
            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }
}