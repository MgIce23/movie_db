package com.aungpyaesone.firebasetest.padcx_movieapp_aps

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.getNowPlayingDummy
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.getPopularMovies
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.*
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.mockmodels.GenerListMockModelImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.mockmodels.NowPlayingMockModelImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.mockmodels.PopularMockkModel
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.mockmodels.PopularPeopleMockImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls.MovieHomePresenterImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieHomeView
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


@RunWith(AndroidJUnit4::class)
class MovieHomePresenterImplTest {

    private lateinit var mPresenter: MovieHomePresenterImpl

    @RelaxedMockK
    private lateinit var mMainView : MovieHomeView

    private lateinit var mPopularMovieModel: PopularMovieModel
    private lateinit var mNowPlayingMovieModel: NowPlayingMovieModel
    private lateinit var mPopularPeople: PopularPeopleModel
    private lateinit var mGenerModel : GenerListModel

    @Before
    fun setUpPresenter(){
        MockKAnnotations.init(this)
        PopularMovieImpl.initDatabase(ApplicationProvider.getApplicationContext())
        NowPlayingMovieImpl.initDatabase(ApplicationProvider.getApplicationContext())
        PopularPeopleImpl.initDatabase(ApplicationProvider.getApplicationContext())
        GenerModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        GenerModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mPopularMovieModel = PopularMockkModel
        mNowPlayingMovieModel = NowPlayingMockModelImpl
        mPopularPeople = PopularPeopleMockImpl
        mGenerModel = GenerListMockModelImpl
        mPresenter = MovieHomePresenterImpl()
        mPresenter.initPresenter(mMainView)
        mPresenter.mPopularMovie = this.mPopularMovieModel
        mPresenter.mNowPalyingMovie = this.mNowPlayingMovieModel
        mPresenter.mPopularPeople = this.mPopularPeople
        mPresenter.mGener = this.mGenerModel

    }

    @Test
    fun onUiReady_CallPopularMovieList(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)
        mPresenter.onUiReady(lifecycleOwner)
        verify {
            mMainView.showPopularMovie(getPopularMovies())
            mMainView.showNowPlayingMovieList(getNowPlayingDummy())
        }
    }

    @Test
    fun onTouchPopularMovieItem(){
        val pMovieOne = PopularMovieVO(
            popularity = 144.929f,
            poster_path = " ",
            overview = " ",
            release_date = " ",
            genre_ids = arrayListOf(),
            id = 300671,
            original_language = " ",
            original_title = " ",
            title = " ",
            backdrop_path = " ",
            video = false,
            vote_average = 7.1f,
            vote_count = 20
        )
        mPresenter.onTouchItem(pMovieOne.id)
        verify {
            mMainView.navigateToDetail(pMovieOne.id)
        }
    }




}