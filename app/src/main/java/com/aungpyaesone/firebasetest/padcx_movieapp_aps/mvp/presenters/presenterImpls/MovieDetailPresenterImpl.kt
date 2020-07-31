package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.MovieDetailImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.MovieDetailModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.AbstractBasePresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.MovieDetailPresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieDetailView

class MovieDetailPresenterImpl : MovieDetailPresenter,AbstractBasePresenter<MovieDetailView>() {

    private val mMovieDetail: MovieDetailModel = MovieDetailImpl

    override fun onUiReady(movieId: Int, lifecycleOwner: LifecycleOwner) {

        mMovieDetail.getMovieDetailsAndSaveToDatabase(movieId, onSuccess = {},
            onError = {
                mView?.showErrorMessage(it)
            })
        mMovieDetail.getMovieDetails(movieId) {
            mView?.showErrorMessage(it)
        }.observe(lifecycleOwner, Observer {
            it?.let {
                mView?.bindData(it)
            } ?: arrayListOf<MovieVO>()

        })

        mMovieDetail.getAllPopularPeople {
            mView?.showErrorMessage(it)
        }.observe(lifecycleOwner, Observer {
            it?.let {
                mView?.showActorList(it)
            } ?: arrayListOf<PeopleVO>()
        })


    }
}
