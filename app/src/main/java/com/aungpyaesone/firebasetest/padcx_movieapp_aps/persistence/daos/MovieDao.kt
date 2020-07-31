package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

@Dao
interface MovieDao{

    @Query("SELECT * FROM movies")
     fun getAllPopular() : LiveData<List<PopularMovieVO>>

    @Query("SELECT * FROM movies WHERE id = :movieId")
     fun getMovieById(movieId :Int) : LiveData<PopularMovieVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovie(popularMovieVO: PopularMovieVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovieList(news: List<PopularMovieVO>)

    @Query("SELECT * FROM movies ORDER BY id Desc LIMIT 5")
    fun getPosterPath():LiveData<List<PopularMovieVO>>
}