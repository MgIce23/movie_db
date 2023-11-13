package com.aungpyaesone.firebasetest.padcx_movieapp_aps.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter.ActorListAdapter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter.CeatorAdapter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.*
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.MovieDetailPresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls.MovieDetailPresenterImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.MovieDetailView
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide
import com.example.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity() , MovieDetailView{

    private var mPresenter : MovieDetailPresenter? = null
    private lateinit var mCreatorAdapter: CeatorAdapter
    private lateinit var mActorAdapter: ActorListAdapter

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
        setUpListener()
        mPresenter?.onUiReady(movieId,this)
    }

    private fun setUpListener(){
        ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupRecycler(){
        mActorAdapter= ActorListAdapter()
        rvActors.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvActors.adapter = mActorAdapter

        mCreatorAdapter = CeatorAdapter()
        rvCreator.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCreator.adapter = mCreatorAdapter
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
        tvYear.text = data.release_date.substringBefore("-")
        tvRating.text = data.vote_average.toString()
        tvVote.text = data.vote_count.toString() + "   VOTES"
        tvMovieTitle.text = data.original_title
        Log.d("Tag",data.genres.size.toString())
     //   createDynamicChip(data.genres,chipGroup)
        tvStoryLine.text = data.overview
        tvOriginalTitle.text = data.original_title
        tvType.text = showType(data.genres)
        if(data.production_countries.isNotEmpty()){
            tvProduction.text = data.production_countries.get(0).name
        }
        tvDescription.text = data.overview
    }

    private fun showType(dataList:List<GenersVO>):String{
        var result : String = " "
        for(data in dataList){
            result += data.name
            result += " "
        }
        return result

    }

    override fun showActorList(dataList: List<CastVO>) {
        mActorAdapter.setData(dataList.toMutableList())

    }

    override fun showCreatorList(dataList: List<CrewVO>) {
       mCreatorAdapter.setData(dataList.toMutableList())
    }


    override fun showErrorMessage(error: String) {
       showSnackBar(error)
    }

}