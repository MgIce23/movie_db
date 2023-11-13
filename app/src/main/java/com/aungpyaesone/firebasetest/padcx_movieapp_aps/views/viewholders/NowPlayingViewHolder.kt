package com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders

import android.view.View
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.NowPlayingVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.ItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide
import com.example.shared.views.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.showcase_item_view.view.*

class NowPlayingViewHolder(itemView: View,val mDelegate:ItemDelegate) : BaseViewHolder<NowPlayingVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTouchItem(it.id)
            }
        }
    }

    override fun bindData(data: NowPlayingVO) {
        mData = data

        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL + data.backdrop_path)
            .into(itemView.ivPoster)

        itemView.tvMovieTitle.text  = data.title
        itemView.tvShowtime.text = data.release_date
    }
}