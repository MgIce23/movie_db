package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

interface MovieDetailView: BaseView {
    fun bindData(data:MovieVO)

    fun showActorList(dataList: List<PeopleVO>)
}