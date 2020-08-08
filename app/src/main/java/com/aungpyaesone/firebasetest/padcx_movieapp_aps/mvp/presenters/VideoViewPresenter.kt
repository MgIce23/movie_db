package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.VideoView
import com.example.shared.mvp.presenters.BasePresenter

interface VideoViewPresenter : BasePresenter<VideoView> {
    fun onUiReady(movieId: Int,lifecycleOwner: LifecycleOwner)
}