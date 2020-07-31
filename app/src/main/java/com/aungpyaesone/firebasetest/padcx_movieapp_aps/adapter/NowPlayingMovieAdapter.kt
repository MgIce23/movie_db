package com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.NowPlayingVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.BaseViewHolder
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.NowPlayingViewHolder

class NowPlayingMovieAdapter : BaseAdapter<BaseViewHolder<NowPlayingVO>,NowPlayingVO>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<NowPlayingVO> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.showcase_item_view,parent,false)
        return NowPlayingViewHolder(v)
    }
}