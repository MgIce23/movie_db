package com.aungpyaesone.firebasetest.padcx_movieapp_aps.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetNowPlayingMovieWorker(context: Context, workerParams: WorkerParameters)
    : BaseWorker(context,workerParams){

    override fun doWork(): Result {

        var result = Result.failure()
        mNowPlayingMovie.getAllNowPlayingMovieFromApiSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onFailure = {
                result = Result.failure()
            }
        )
        return result
    }

}