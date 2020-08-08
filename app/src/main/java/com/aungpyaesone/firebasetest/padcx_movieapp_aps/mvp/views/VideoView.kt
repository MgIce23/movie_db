package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views

import com.example.shared.mvp.views.BaseView

interface VideoView  : BaseView {

    fun showVideo(videoKey: String)
}