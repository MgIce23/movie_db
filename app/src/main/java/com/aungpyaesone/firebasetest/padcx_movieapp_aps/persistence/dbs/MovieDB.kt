package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.dbs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.*
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.daos.*

@Database(entities = [PopularMovieVO::class, NowPlayingVO::class,
PeopleVO::class,TopRatedVO::class,MovieVO::class], version = 5, exportSchema = false)
abstract class MovieDB : RoomDatabase(){
    companion object {
        val DB_NAME = "PADC_NEWS_X.DB"
        var dbInstance: MovieDB? = null

        fun getDBInstance(context: Context): MovieDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MovieDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            val i = dbInstance
            return i!!
        }
    }
    abstract fun moviesDao(): MovieDao
    abstract fun nowPlayingDao(): NowPlayingMovieDao
    abstract fun popularPeopleDao(): PopularPeopleDao
    abstract fun topRateMovieDao(): TopRateMovieDao
    abstract fun movieDetailDao(): MovieDetailDao
}