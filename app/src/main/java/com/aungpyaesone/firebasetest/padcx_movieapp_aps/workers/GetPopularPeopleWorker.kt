package com.aungpyaesone.firebasetest.padcx_movieapp_aps.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetPopularPeopleWorker(context: Context, workerParams: WorkerParameters)
    : BaseWorker(context,workerParams) {
    override fun doWork(): Result {
        var result = Result.failure()
        mPopularPeople.getPopularPeopleFromApiSaveToDB(
            {
                result = Result.success()
            },{
                result = Result.failure()
            }
        )
        return result
    }
}