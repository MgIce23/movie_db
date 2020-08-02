package com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieWithGenerVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.TopRatedVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.TopRatedMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.BaseViewHolder
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.TopMovieViewHolder

class TopRatedMovieAdapter(val mDelegate:TopRatedMovieItemDelegate) : BaseAdapter<BaseViewHolder<MovieWithGenerVO>,MovieWithGenerVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MovieWithGenerVO> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_poster_item_view,parent,false)
        return TopMovieViewHolder(v,mDelegate)
    }
}