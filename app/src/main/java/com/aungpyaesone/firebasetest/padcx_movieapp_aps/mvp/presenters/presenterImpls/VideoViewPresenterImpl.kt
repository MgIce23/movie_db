package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls

import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.PopularMovieImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.AbstractBasePresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.VideoViewPresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.VideoView

class VideoViewPresenterImpl : VideoViewPresenter,AbstractBasePresenter<VideoView>(){
    var mPopularModel = PopularMovieImpl
    override fun onUiReady(movieId:Int,lifecycleOwner: LifecycleOwner) {
        mPopularModel.getVideoFromApi(
            movieId,
            onSuccess = {
                mView?.showVideo(it.get(0).key)
            },
            onError = {mView?.showErrorMessage(it)}
        )
    }

}