package com.aungpyaesone.firebasetest.padcx_movieapp_aps.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter.PopularPeopleAdapter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.MovieDetailPresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls.MovieDetailPresenterImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieDetailView
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity() , MovieDetailView{

    private var mPresenter : MovieDetailPresenter? = null
    private lateinit var mPopularPeopleAdapter : PopularPeopleAdapter

    companion object{
        const val KEY = "key"
        var movieId : Int = 0
        fun newIntent(context: Context,id:Int): Intent {
            val i = Intent(context,MovieDetailActivity::class.java)
            i.putExtra(KEY,id)
            return i
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setUpPresenter()
        setUpData()
        setupRecycler()
        mPresenter?.onUiReady(movieId,this)
    }

    private fun setupRecycler(){
        mPopularPeopleAdapter = PopularPeopleAdapter()
        rvActors.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvActors.adapter = mPopularPeopleAdapter
        rvCreator.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCreator.adapter = mPopularPeopleAdapter
    }

    private fun setUpData(){
        movieId = intent.getIntExtra(KEY,0)
    }
    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MovieDetailPresenterImpl::class.java)
        mPresenter?.initPresenter(this)
    }

    @SuppressLint("SetTextI18n")
    override fun bindData(data: MovieVO) {
        Glide.with(applicationContext)
            .load(IMAGE_BASE_URL + data.poster_path)
            .into(ivPoster)
        tvRating.text = data.vote_average.toString()
        tvVote.text = data.vote_count.toString() + "   VOTES"
        tvMovieTitle.text = data.original_title
        chipOne.text = data.genres.get(0).name
        chipTwo.text = data.genres.get(1).name
        tvStoryLine.text = data.overview
        tvOriginalTitle.text = data.original_title
        tvType.text = chipOne.text.toString() + chipTwo.text + chipThree.text.toString()
        tvProduction.text = data.production_countries.get(0).name
    }

    override fun showActorList(dataList: List<PeopleVO>) {
        mPopularPeopleAdapter.setData(dataList)
    }

    override fun showErrorMessage(error: String) {
       showSnackBar(error)
    }

}