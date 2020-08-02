package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO

@Dao
interface GenerDao {
    @Query("SELECT * FROM Gener")
    fun getAllGener() : LiveData<List<GenersVO>>

    @Query("SELECT * FROM Gener WHERE id = :generId")
    fun getGenerById(generId :Int) : LiveData<GenersVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGener(genersVO: GenersVO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGenerList(news: List<GenersVO>)
}