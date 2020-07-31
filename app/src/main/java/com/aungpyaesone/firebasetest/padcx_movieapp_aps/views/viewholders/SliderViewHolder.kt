package com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders

import android.view.View
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.ItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.BASE_URL
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide

import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.slider_layout.view.*
import kotlinx.android.synthetic.main.slider_layout.view.ivPoster

class SliderViewHolder(itemView: View?,val mDelegate:ItemDelegate) : SliderViewAdapter.ViewHolder(itemView) {

    var mData : PopularMovieVO? = null
    init {
        itemView?.setOnClickListener {
                mData?.let {
                    mDelegate.onTouchItem(it.id)
            }
        }

    }
    fun bindData(data: PopularMovieVO){
       // val mData = data
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL + data.poster_path)
            .centerCrop()
            .into(itemView.ivPoster)

        itemView.tvTitle.text = data.title
    }
}