package com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders

import android.view.View
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.NowPlayingVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.showcase_item_view.view.*

class NowPlayingViewHolder(itemView: View) : BaseViewHolder<NowPlayingVO>(itemView) {
    override fun bindData(data: NowPlayingVO) {
        mData = data

        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL + data.backdrop_path)
            .into(itemView.ivPoster)

        itemView.tvMovieTitle.text  = data.title
        itemView.tvShowtime.text = data.release_date
    }
}