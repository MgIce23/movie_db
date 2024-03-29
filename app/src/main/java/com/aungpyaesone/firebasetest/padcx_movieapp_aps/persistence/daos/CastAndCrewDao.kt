package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CastAndCrewVO

@Dao
interface CastAndCrewDao {
    @Query("SELECT * FROM castAndCrew")
    fun getAllCast() : LiveData<List<CastAndCrewVO>>

    @Query("SELECT * FROM castAndCrew WHERE id = :movieId")
    fun getCastById(movieId :Int) : LiveData<CastAndCrewVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCast(castAndcrew: CastAndCrewVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCastList(news: List<CastAndCrewVO>)
}