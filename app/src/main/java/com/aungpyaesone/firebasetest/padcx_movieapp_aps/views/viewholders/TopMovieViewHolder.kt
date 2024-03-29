package com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders

import android.view.View
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieWithGenerVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.TopRatedVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.TopRatedMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide
import com.example.shared.views.viewholder.BaseViewHolder

import kotlinx.android.synthetic.main.movie_poster_item_view.view.*

class TopMovieViewHolder(itemView: View,val mDelegate:TopRatedMovieItemDelegate) : BaseViewHolder<MovieWithGenerVO>(itemView){

    init {
        itemView.setOnClickListener {
            mData.let {
                it?.id?.let {
                        it1 -> mDelegate.onTouchRatedMovie(it1) }
            }
        }
    }

    override fun bindData(data: MovieWithGenerVO) {
        mData = data


        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL + data.poster_path)
            .centerCrop()
            .into(itemView.ivPoster)

        itemView.tvMovieTitle.text = data.title
        itemView.ivMovieRate.text = data.vote_average.toString()
        itemView.ratingBar.progress = data.vote_average.toInt()
    }


}