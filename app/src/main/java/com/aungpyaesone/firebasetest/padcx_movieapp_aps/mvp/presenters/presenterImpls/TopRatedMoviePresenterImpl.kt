package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.TopRateMovieModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.TopRatedMovieImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.TopRatedVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.AbstractBasePresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.TopRatedMoviePresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.TopRatedMovieView

class TopRatedMoviePresenterImpl : TopRatedMoviePresenter,AbstractBasePresenter<TopRatedMovieView>() {

    private val mTopRatedMovie: TopRateMovieModel = TopRatedMovieImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mTopRatedMovie.getAllTopMovieList {
            mView?.showErrorMessage(it)
        }.observe(lifecycleOwner, Observer {
            mView?.showTopRatedMovieList(it)
        })
    }

    override fun onTouchRatedMovie(id: Int) {
        mView?.navigateToDetailScreen(id)
    }
}