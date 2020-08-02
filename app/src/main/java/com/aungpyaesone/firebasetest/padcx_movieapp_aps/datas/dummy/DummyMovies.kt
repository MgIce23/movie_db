package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.dummy

import androidx.lifecycle.LiveData
import androidx.room.PrimaryKey
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.*
import com.google.gson.annotations.SerializedName

fun getPopularMovies(): List<PopularMovieVO>{

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
    val pMovieTwo = PopularMovieVO(
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

    val pMovieThree = PopularMovieVO(
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

    return arrayListOf(pMovieOne,pMovieTwo,pMovieThree)
}

fun getNowPlayingDummy(): List<NowPlayingVO>{
    val pMovieOne = NowPlayingVO(
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
    val pMovieTwo = NowPlayingVO(
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

    val pMovieThree = NowPlayingVO(
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

    return arrayListOf(pMovieOne,pMovieTwo,pMovieThree)
}

fun getMovieVO(): MovieVO{
    val movieVO = MovieVO(
        adult = true,
        backdrop_path = " ",
        budget = 0,
        genres= arrayListOf(),
        homepage = null,
        id= 0,
        imdb_id = null,
        original_language = " ",
        original_title = "",
        overview = null,
        popularity = 0.5f,
        poster_path =  null,
        production_companies = arrayListOf(),
        production_countries= arrayListOf(),
        release_date = " ",
        revenue = 123,
        runtime = null,
        spoken_languages= arrayListOf(),
        status = "",
        tagline = null,
        video = false,
        vote_average = 0.3f,
        vote_count = 10
    )

    return movieVO
}

fun getcastVO (): List<CastVO>{
    val castVO = CastVO(  cast_id =22,
        character = "",
        credit_id = "222",
        gender = 28,
        id = 1,
        name= "",
        order = 100,
        profile_path = "")
    return arrayListOf(castVO)
}

fun getCrewVO(): List<CrewVO>{
    val crewVO = CrewVO(
       credit_id ="",
       job ="",
       id =1,
      gender = 2,
         name = "",
        department ="",
       profile_path = ""
    )
    return arrayListOf(crewVO)
}