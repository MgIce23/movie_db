package com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CastVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CrewVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.BaseViewHolder
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.CreatorListViewHolder

class CeatorAdapter : BaseAdapter<BaseViewHolder<CrewVO>,CrewVO>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CrewVO> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.actors_creators_item_view,parent,false)
        return CreatorListViewHolder(v)
    }

}