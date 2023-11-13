package com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders

import android.view.View
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.PopularMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide
import com.example.shared.views.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.movie_poster_item_view.view.*

class BestPopularFilmViewHolder(itemView: View,val mDelegate: PopularMovieItemDelegate) : BaseViewHolder<PopularMovieVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTouchPopularMovieItemDelegate(it.id)
            }
        }
    }
    override fun bindData(data: PopularMovieVO) {
        mData = data

        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL + data.poster_path)
            .into(itemView.ivPoster)
        itemView.tvMovieTitle.text = data.title
        itemView.ivMovieRate.text = data.vote_average.toString()
        itemView.ratingBar.rating = data.vote_average
    }
}