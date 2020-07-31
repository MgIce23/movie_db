package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.API_KEY
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.EN_ERROR_MESSAGE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PopularPeopleImpl : BaseModel(),PopularPeopleModel {

    @SuppressLint("CheckResult")
    override fun getPopularPeopleFromApiSaveToDB(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mClientApi.getPopularPeople(API_KEY)
            .map {
                it.result.toList()
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.popularPeopleDao().insertAllPopularPeopleList(it)
            },{
                onError(it.localizedMessage ?: EN_ERROR_MESSAGE)
            })
    }

    override fun getAllPeoplePoster(onError: (String) -> Unit): LiveData<List<PeopleVO>> {
        return mTheDB.popularPeopleDao().getPopularPeoples()
    }
}