package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PeopleVO

@Dao
interface PopularPeopleDao {
    @Query("SELECT * FROM peoples ORDER BY id desc")
    fun getAllPopularPeople() : LiveData<List<PeopleVO>>

    @Query("SELECT * FROM peoples")
    fun getPopularPeoples() : LiveData<List<PeopleVO>>

    @Query("SELECT * FROM peoples WHERE id = :peopleId")
    fun getPeopleById(peopleId :Int) : LiveData<PeopleVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPopularPeople(popularMovieVO: PeopleVO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPopularPeopleList(news: List<PeopleVO>)
}