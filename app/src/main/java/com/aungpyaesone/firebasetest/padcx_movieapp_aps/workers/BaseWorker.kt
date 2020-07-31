package com.aungpyaesone.firebasetest.padcx_movieapp_aps.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.*

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    val mPopularMovie : PopularMovieModel = PopularMovieImpl
    val mNowPlayingMovie : NowPlayingMovieModel = NowPlayingMovieImpl
    val mPopularPeople: PopularPeopleModel = PopularPeopleImpl
    val mTopRateMovie: TopRateMovieModel = TopRatedMovieImpl
}