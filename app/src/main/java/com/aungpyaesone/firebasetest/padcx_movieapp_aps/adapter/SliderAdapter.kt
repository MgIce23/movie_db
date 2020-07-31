package com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.Slide
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.ItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.SliderViewHolder
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(val mDelegate:ItemDelegate) : SliderViewAdapter<SliderViewHolder>(){
    private var mDataList = arrayListOf<PopularMovieVO>()
    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.slider_layout,parent,false)
        return SliderViewHolder(v,mDelegate)
    }

    override fun getCount(): Int {
       return mDataList.size
    }

    fun setData(data: List<PopularMovieVO>){
        mDataList.clear()
        mDataList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        viewHolder?.bindData(mDataList[position])
    }


}