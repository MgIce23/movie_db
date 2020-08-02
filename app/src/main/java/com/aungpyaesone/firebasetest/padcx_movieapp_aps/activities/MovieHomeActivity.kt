package com.aungpyaesone.firebasetest.padcx_movieapp_aps.activities

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter.*
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.NowPlayingVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.MovieHomePresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls.MovieHomePresenterImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieHomeView
import kotlinx.android.synthetic.main.activity_movie_detail.rvActors
import kotlinx.android.synthetic.main.activity_movie_home.*
import kotlinx.android.synthetic.main.showcase_view_pod.*

class MovieHomeActivity : BaseActivity(), MovieHomeView {
    private lateinit var mSliderAdapter: SliderAdapter
    private lateinit var mPresenter : MovieHomePresenter
    private lateinit var mBestPopularFlimAdapter: BestPopularFlimAdapter
 //   private lateinit var mViewPagerAdapter: ViewPagerAdapter
    private lateinit var mNowPlayingMovieAdapter : NowPlayingMovieAdapter
    private lateinit var mPopularPeopleAdapter : PopularPeopleAdapter
    private lateinit var mPagerAdapter: DynamicPagerAdapter

    private var mGenerList = arrayListOf<GenersVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_home)
        setUpPresenter()
        setUpSlider()
        setUpRecycler()
        setUpViewPager()

        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MovieHomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpSlider(){
        mSliderAdapter = SliderAdapter(mPresenter)
        slider_pagerView.setSliderAdapter(mSliderAdapter)
    }

    private fun setUpRecycler(){
        mBestPopularFlimAdapter = BestPopularFlimAdapter(mPresenter)
        rvBestFlimandSeries.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvBestFlimandSeries.adapter =mBestPopularFlimAdapter

        mNowPlayingMovieAdapter = NowPlayingMovieAdapter(mPresenter)
        rvShowCase.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvShowCase.adapter =mNowPlayingMovieAdapter

        mPopularPeopleAdapter = PopularPeopleAdapter()
        rvActors.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvActors.adapter = mPopularPeopleAdapter
    }

    private fun setUpViewPager(){
      //  mViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)


    }

    override fun showPopularMovie(popularMovie: List<PopularMovieVO>) {
        mBestPopularFlimAdapter.setData(popularMovie)
    }

    override fun showNowPlayingMovieList(upComingMovie: List<NowPlayingVO>) {
        mNowPlayingMovieAdapter.setData(upComingMovie.toMutableList())
    }

    override fun showPopularPeopleList(popularPeople: List<PeopleVO>) {
        mPopularPeopleAdapter.setData(popularPeople.toMutableList())
    }

    override fun showPosterList(posterList: List<PopularMovieVO>) {
        mSliderAdapter.setData(posterList)
    }

    override fun navigateToDetail(id: Int) {
        startActivity(VideoViewActivity.newIntent(this,id))
    }

    override fun navigateToMovieDetail(id: Int) {
       startActivity(MovieDetailActivity.newIntent(this,id))
    }

    override fun sendGenerList(generList: List<GenersVO>) {
        mPagerAdapter = DynamicPagerAdapter(generList,supportFragmentManager)
        generViewPager.adapter = mPagerAdapter
        tabLayout.setupWithViewPager(generViewPager)
    }

    override fun showErrorMessage(error: String) {
        showSnackBar(error)
    }
}