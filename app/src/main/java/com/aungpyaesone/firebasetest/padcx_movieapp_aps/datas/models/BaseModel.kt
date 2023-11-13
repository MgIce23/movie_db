package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models

import android.content.Context
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.BuildConfig
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.network.ClientApi
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.dbs.MovieDB
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

   protected var mClientApi:ClientApi
   protected lateinit var mTheDB:MovieDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_FIELD)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mClientApi = retrofit.create(ClientApi::class.java)
    }

    fun initDatabase(context: Context)
    {
        mTheDB = MovieDB.getDBInstance(context)
    }
}