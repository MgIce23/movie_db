package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import androidx.lifecycle.LiveData
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO

interface PopularPeopleModel {
    fun getPopularPeopleFromApiSaveToDB(onSuccess:()->Unit,onError : (String)->Unit)

    fun getAllPeoplePoster(onError: (String) -> Unit): LiveData<List<PeopleVO>>
}