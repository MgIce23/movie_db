package com.aungpyaesone.firebasetest.padcx_movieapp_aps

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.*
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.workers.GetMovieWorker
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.workers.GetNowPlayingMovieWorker
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.workers.GetPopularPeopleWorker
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.workers.GetTopRateMovieWorker

class MovieApp : Application(){
    override fun onCreate() {
        super.onCreate()
        PopularMovieImpl.initDatabase(applicationContext)
        NowPlayingMovieImpl.initDatabase(applicationContext)
        PopularPeopleImpl.initDatabase(applicationContext)
        TopRatedMovieImpl.initDatabase(applicationContext)
        MovieDetailImpl.initDatabase(applicationContext)
        GenerModelImpl.initDatabase(applicationContext)

        getPopularMovieOneTime()
        getNowPlayingMovieOneTime()
        getPopularPeopleOneTime()
        getTopRatedMovieOneTime()
    }
    private fun getPopularMovieOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetMovieWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

    private fun getNowPlayingMovieOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetNowPlayingMovieWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

    private fun getPopularPeopleOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetPopularPeopleWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }
    private fun getTopRatedMovieOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetTopRateMovieWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }
}