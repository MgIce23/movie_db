package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.Slide

fun getSlider() : List<Slide>{
    val slideOne = Slide("/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg","Slide One")
    val slideTwo = Slide( "/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg","Slide Two")
    val slideThree = Slide("/jHo2M1OiH9Re33jYtUQdfzPeUkx.jpg", "Slide Three")

    return arrayListOf(slideOne,slideTwo,slideThree)
}