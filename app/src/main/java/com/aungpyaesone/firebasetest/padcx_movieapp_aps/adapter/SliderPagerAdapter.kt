package com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.Slide
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.BASE_URL
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.slider_layout.view.*

class SliderPagerAdapter(val mContext: Context,val mSlide: List<Slide>) : PagerAdapter(){
    override fun getCount(): Int {
       return mSlide.size
    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return  p0 == p1
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater : LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val slideLayout : View = layoutInflater.inflate(R.layout.slider_layout,null)

        Glide.with(slideLayout.context)
            .load(BASE_URL + mSlide.get(position).posterPath)
            .into(slideLayout.ivPoster)
        //slideLayout.tvMovieTitle.text = mSlide.get(position).title
        container.addView(slideLayout)
        return slideLayout

    }

}