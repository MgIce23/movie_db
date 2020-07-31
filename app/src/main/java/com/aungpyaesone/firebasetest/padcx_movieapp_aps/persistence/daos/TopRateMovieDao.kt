package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.TopRatedVO

@Dao
interface TopRateMovieDao {
    @Query("SELECT * FROM topMovie")
    fun getAllTopRateMovie() : LiveData<List<TopRatedVO>>

    @Query("SELECT * FROM topMovie WHERE id = :movieId")
    fun getMovieById(movieId :Int) : LiveData<TopRatedVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRateMovie(topRateMovie: TopRatedVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRateMovieList(topRateMovie: List<TopRatedVO>)
}