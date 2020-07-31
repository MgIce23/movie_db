package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

@Dao
interface MovieDetailDao{
    @Query("SELECT * FROM moviedetail WHERE id = :movieId")
    fun getMovieById(movieId :Int) : LiveData<MovieVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetail(movieDetail: MovieVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovieList(news: List<MovieVO>)
}