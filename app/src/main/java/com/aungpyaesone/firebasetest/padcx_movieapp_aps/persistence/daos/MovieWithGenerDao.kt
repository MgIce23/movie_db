package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CastAndCrewVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieWithGenerVO

@Dao
interface MovieWithGenerDao {
    @Query("SELECT * FROM movieWithGener")
    fun getAllMovies() : LiveData<List<MovieWithGenerVO>>

    @Query("SELECT * FROM movieWithGener WHERE id = :movieId")
    fun getMovieGenerById(movieId :Int) : LiveData<MovieWithGenerVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMoviewWithGener(movieGener: MovieWithGenerVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieWithGenerList(movieWithGener: List<MovieWithGenerVO>)
}