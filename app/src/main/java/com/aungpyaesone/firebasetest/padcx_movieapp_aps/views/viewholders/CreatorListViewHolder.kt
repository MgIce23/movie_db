package com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders

import android.view.View
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CastVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CrewVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.actors_creators_item_view.view.*


class CreatorListViewHolder(itemView: View) : BaseViewHolder<CrewVO>(itemView){
    override fun bindData(data: CrewVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL + data.profile_path)
            .centerCrop()
            .into(itemView.ivPoser)
        itemView.tvName.text = data.name
    }

}