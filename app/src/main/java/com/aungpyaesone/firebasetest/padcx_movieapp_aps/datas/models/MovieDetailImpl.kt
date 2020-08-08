package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.BuildConfig
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CastAndCrewVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.EN_ERROR_MESSAGE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieDetailImpl: BaseModel(), MovieDetailModel{
    @SuppressLint("CheckResult")
    override fun getMovieDetailsAndSaveToDatabase(movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mClientApi.getMovieDetails(movieId, BuildConfig.MY_API_KEY)
            .map { it?.let { it } }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
               mTheDB.movieDetailDao().insertMovieDetail(it)
            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    override fun getMovieDetails(id:Int,onError: (String) -> Unit): LiveData<MovieVO> {
       return mTheDB.movieDetailDao().getMovieById(id)
    }

    override fun getAllPopularPeople(onError: (String) -> Unit): LiveData<List<PeopleVO>> {
        return mTheDB.popularPeopleDao().getAllPopularPeople()
    }

    @SuppressLint("CheckResult")
    override fun getAllCastAndCrewFromApiSaveDataBase(
        id: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mClientApi.getCastAndCrew(id, BuildConfig.MY_API_KEY)
            .map {
               it
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
              mTheDB.castAndCrewDao().insertCast(it)
            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    override fun getAllCastAndCrew(id:Int,onError: (String) -> Unit): LiveData<CastAndCrewVO> {
        return mTheDB.castAndCrewDao().getCastById(id)
    }

}