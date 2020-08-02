package com.aungpyaesone.firebasetest.padcx_movieapp_aps

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.*
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.MovieDetailImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.MovieDetailModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.PopularMovieImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.mockmodels.MovieDetailMockModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls.MovieDetailPresenterImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieDetailView
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieHomeView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito


@RunWith(AndroidJUnit4::class)
class MovieDetailPresenterImplTest {

    private lateinit var mDetailPresenter: MovieDetailPresenterImpl

    @RelaxedMockK
    private lateinit var mDetailView : MovieDetailView

    private lateinit var mMovieDetailModel: MovieDetailModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)
        MovieDetailImpl.initDatabase(ApplicationProvider.getApplicationContext())

        mMovieDetailModel = MovieDetailMockModel
        mDetailPresenter = MovieDetailPresenterImpl()
        mDetailPresenter.initPresenter(mDetailView)
        mDetailPresenter.mMovieDetail = this.mMovieDetailModel
    }

    @Test
    fun onUiReadyForMovieDetail(){
        val lifecycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mDetailPresenter.onUiReady(1,lifecycleOwner)
        verify {
           mDetailView.bindData(getMovieVO())
        }
    }
}