package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.*
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.MovieHomePresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieHomeView
import com.example.shared.mvp.presenters.AbstractBasePresenter

class MovieHomePresenterImpl : MovieHomePresenter, AbstractBasePresenter<MovieHomeView>() {
   // private val mBestPopularFilAndSerial: BestPopularFilmAndSerialModel = BestPopularFilmAndSerialImpl()
     var mPopularMovie : PopularMovieModel = PopularMovieImpl
     var mNowPalyingMovie : NowPlayingMovieModel = NowPlayingMovieImpl
    var mPopularPeople: PopularPeopleModel = PopularPeopleImpl
     var mGener: GenerListModel = GenerModelImpl


    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
       mPopularMovie.getAllPopularMovieList {
           mView?.showErrorMessage(it)
       }.observe(lifecycleOwner, Observer {
           mView?.showPopularMovie(it)
       })

       mNowPalyingMovie.getAllNowPlayingMovieList{
           mView?.showErrorMessage(it)
       }.observe(lifecycleOwner, Observer {
            mView?.showNowPlayingMovieList(it)
       })

        mPopularPeople.getAllPeoplePoster {
            mView?.showErrorMessage(it)
        }.observe(lifecycleOwner, Observer {
            mView?.showPopularPeopleList(it)
        })

        mPopularMovie.getPosterPath {
            mView?.showErrorMessage(it)
        }.observe(lifecycleOwner, Observer {
            mView?.showPosterList(it)
        })

        mGener.getGenersListFromApiSaveToDB({},{
            mView?.showErrorMessage(it)
        })
        mGener.getAllGenerList {
            mView?.showErrorMessage(it)
        }.observe(lifecycleOwner, Observer {
            mView?.sendGenerList(it)
        })


    }

    override fun onTouchItem(id: Int) {
        mView?.navigateToDetail(id)
    }

    override fun onTouchPopularMovieItemDelegate(id: Int) {
        mView?.navigateToMovieDetail(id)
    }

    override fun onTouchRatedMovie(id: Int) {
        mView?.navigateToMovieDetail(id)
    }
}