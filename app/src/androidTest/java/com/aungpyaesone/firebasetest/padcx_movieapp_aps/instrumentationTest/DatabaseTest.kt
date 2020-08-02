package com.aungpyaesone.firebasetest.padcx_movieapp_aps.instrumentationTest

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.daos.MovieDao
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.dbs.MovieDB
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest {
    private lateinit var movieDao : MovieDao
    private lateinit var db: MovieDB

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,MovieDB::class.java).build()
        movieDao = db.moviesDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun InsertIntoDataBase(){
        val pMovieOne = PopularMovieVO(
            popularity = 144.929f,
            poster_path = " ",
            overview = " ",
            release_date = " ",
            genre_ids = arrayListOf(),
            id = 300671,
            original_language = " ",
            original_title = " ",
            title = " ",
            backdrop_path = " ",
            video = false,
            vote_average = 7.1f,
            vote_count = 20
        )
        movieDao.insertPopularMovie(pMovieOne)
        assert(movieDao.getMovieById(pMovieOne.id).value?.id == pMovieOne.id)
    }
}