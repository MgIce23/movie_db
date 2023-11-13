package com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders

import android.view.View
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide
import com.example.shared.views.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.actors_creators_item_view.view.*

class PopularPeopleViewHolder(itemView: View) : BaseViewHolder<PeopleVO>(itemView){
//    init {
//        itemView.setOnClickListener {
//            mData?.let {
//                mDelegate.onTouchItem(it.id)
//            }
//        }
//    }
    override fun bindData(data: PeopleVO) {
        mData = data
        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL + data.profile_path)
            .centerCrop()
            .into(itemView.ivPoser)
        itemView.tvName.text = data.name
    }

}