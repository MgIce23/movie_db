package com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls

import androidx.lifecycle.LifecycleOwner
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.GenerListModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.GenerModelImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.TopRateMovieModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.TopRatedMovieImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.TopRatedMoviePresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.TopRatedMovieView
import com.example.shared.mvp.presenters.AbstractBasePresenter

class TopRatedMoviePresenterImpl : TopRatedMoviePresenter, AbstractBasePresenter<TopRatedMovieView>() {

    private val mTopRatedMovie: TopRateMovieModel = TopRatedMovieImpl
    private val mGenerList: GenerListModel  = GenerModelImpl
    override fun onUiReady(gener:String,lifecycleOwner: LifecycleOwner) {
//        mTopRatedMovie.getAllTopMovieList {
//            mView?.showErrorMessage(it)
//        }.observe(lifecycleOwner, Observer {
//            mView?.showTopRatedMovieList(it)
//        })
        mGenerList.getMovieWithGereFromApiSaveToDB(gener,{
            mView?.showTopRatedMovieList(it)
        },{
            mView?.showErrorMessage(it)
        })
//        mGenerList.getMovieWithGenerList().observe(
//            lifecycleOwner, Observer {
//                mView?.showTopRatedMovieList(it)
//            }
//        )
    }

    override fun onTouchRatedMovie(id: Int) {
        mView?.navigateToDetailScreen(id)
    }
}