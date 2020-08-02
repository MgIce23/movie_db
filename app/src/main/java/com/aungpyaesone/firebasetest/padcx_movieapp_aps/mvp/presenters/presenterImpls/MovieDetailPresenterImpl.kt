package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.MovieDetailImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.MovieDetailModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.AbstractBasePresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.MovieDetailPresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieDetailView

class MovieDetailPresenterImpl : MovieDetailPresenter,AbstractBasePresenter<MovieDetailView>() {

    var mMovieDetail: MovieDetailModel = MovieDetailImpl

    override fun onUiReady(movieId: Int, lifecycleOwner: LifecycleOwner) {

        mMovieDetail.getMovieDetailsAndSaveToDatabase(movieId, onSuccess = {},onError = {
                mView?.showErrorMessage(it)
            })
        mMovieDetail.getMovieDetails(movieId) {
            mView?.showErrorMessage(it)
        }.observe(lifecycleOwner, Observer {
            it?.let {
                mView?.bindData(it)
            } ?: arrayListOf<MovieVO>()

        })

       mMovieDetail.getAllCastAndCrewFromApiSaveDataBase(movieId,onSuccess = {},onError = {
           mView?.showErrorMessage(it)
       })

        mMovieDetail.getAllCastAndCrew(movieId,onError = {}).observe(
            lifecycleOwner, Observer {
                it?.let {
                    mView?.showActorList(it.cast)
                    mView?.showCreatorList(it.crew)
                }
            }
        )
    }
}
