package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.*

interface MovieDetailView: BaseView {
    fun bindData(data:MovieVO)

    fun showActorList(dataList: List<CastVO>)
    fun showCreatorList(dataList: List<CrewVO>)
}