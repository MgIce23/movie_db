package com.aungpyaesone.firebasetest.padcx_movieapp_aps.network

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CastAndCrewVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieWithGenerVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.network.responses.*
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ClientApi {

    @GET(GET_P0PULAR_MOVIES)
    fun getPopularMovies(@Query("api_key") apiKey:String): Observable<GetPopularMovieListResponse>

    @GET(GET_NOW_PLAYING_MOVIES)
    fun getNowPlayingMovie(@Query("api_key") apiKey:String): Observable<GetNowPlayingMovieListRespone>

    @GET(GET_POPULAR_ACTOR)
    fun getPopularPeople(@Query("api_key")apiKey: String):Observable<GetAllPopularPeopleResponse>

    @GET(GET_TOP_RATED_MOVIES)
    fun getTopRatedMovies(@Query("api_key")apiKey: String):Observable<GetTopRatedMovieResponse>

    @GET(GET_MOVIE_DETAILS)
    fun getMovieDetails(@Path("movie_id") movieId:Int,@Query("api_key")apiKey: String): Observable<MovieVO>

    @GET(GET_CAST_AND_CREW)
    fun getCastAndCrew(@Path("movie_id")movieId: Int,@Query("api_key")apiKey: String):Observable<CastAndCrewVO>

    @GET(GET_GENERS_LIST)
    fun getGenerList(@Query("api_key")apiKey: String):Observable<GetAllGenerResponse>

    @GET(GET_MOVIE_WITH_GENER)
    fun getWithGenerList(@Query("api_key")apiKey: String,
                         @Query("with_genres")with_genres: String
    ):Observable<GetMovieWithGenerResponse>

    @GET(GET_VIDEO)
    fun getVideo(@Path("movie_id")movieId: Int,@Query("api_key")apiKey: String)
    :Observable<GetVideoResponse>
}