package com.aungpyaesone.firebasetest.padcx_movieapp_aps.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetMovieWorker (context: Context,workerParams:WorkerParameters)
    : BaseWorker(context,workerParams){
    override fun doWork(): Result {
        var result = Result.failure()

        mPopularMovie.getAllPopularMovieFromApiSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )


        return result
    }

}