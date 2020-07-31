package com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.PopularMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.TopRatedMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.BaseViewHolder
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.BestPopularFilmViewHolder

class BestPopularFlimAdapter(val mDelegate:TopRatedMovieItemDelegate) : BaseAdapter<BaseViewHolder<PopularMovieVO>,PopularMovieVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PopularMovieVO> {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_poster_item_view,parent,false)
        return BestPopularFilmViewHolder(v,mDelegate)
    }


}