package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.*
import com.example.shared.mvp.views.BaseView

interface MovieDetailView: BaseView {
    fun bindData(data:MovieVO)

    fun showActorList(dataList: List<CastVO>)
    fun showCreatorList(dataList: List<CrewVO>)
}