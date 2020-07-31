package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.AbstractBasePresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieDetailView
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.API_KEY
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.EN_ERROR_MESSAGE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MovieDetailImpl: BaseModel(), MovieDetailModel{
    @SuppressLint("CheckResult")
    override fun getMovieDetailsAndSaveToDatabase(movieId: Int,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        mClientApi.getMovieDetails(movieId, API_KEY)
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

}