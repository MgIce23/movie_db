package com.aungpyaesone.firebasetest.padcx_movieapp_aps.network

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.network.responses.GetAllPopularPeopleResponse
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.network.responses.GetNowPlayingMovieListRespone
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.network.responses.GetPopularMovieListResponse
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.network.responses.GetTopRatedMovieResponse
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

}