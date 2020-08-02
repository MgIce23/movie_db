package com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders

import android.view.View
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CastVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.actors_creators_item_view.view.*


class ActorListViewHolder(itemView: View) : BaseViewHolder<CastVO>(itemView){
    override fun bindData(data: CastVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL + data.profile_path)
            .centerCrop()
            .into(itemView.ivPoser)
        itemView.tvName.text = data.name
    }


}