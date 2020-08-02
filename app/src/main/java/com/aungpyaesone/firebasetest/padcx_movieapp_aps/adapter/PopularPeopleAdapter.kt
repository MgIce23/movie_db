package com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.BaseViewHolder
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.PopularPeopleViewHolder

class PopularPeopleAdapter() : BaseAdapter<BaseViewHolder<PeopleVO>,PeopleVO>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PeopleVO> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.actors_creators_item_view,parent,false)
        return PopularPeopleViewHolder(v)
    }

}