package com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils

import android.app.Activity
import android.content.Context
import androidx.viewpager.widget.ViewPager
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.Slide
import java.util.*

class SliderTimer(val mContext: Activity,val slidePager:ViewPager,val lstSlide:List<Slide>)  : TimerTask(){
    override fun run() {
        mContext.runOnUiThread(Runnable(){
            run(){
                if(slidePager.currentItem < lstSlide.size-1){
                       slidePager.currentItem = slidePager.currentItem + 1
                   }
                   else
                   {
                       slidePager.currentItem = 0
                   }
            }
        })
//       mContext.runOnUiThread {
//           Runnable {
//               run(){
//                   if(slidePager.currentItem < lstSlide.size-1){
//                       slidePager.currentItem = slidePager.currentItem + 1
//                   }
//                   else
//                   {
//                       slidePager.currentItem = 0
//                   }
//               }
//           }
//       }
    }

}