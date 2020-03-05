package com.rtr.moviesdemo.network

import com.rtr.moviesdemo.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieApi {
    @GET
    suspend fun getUpcomingMovie(@Url url: String, @Query("api_key") apiKey: String): MoviesResponse


   /* @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("api_key") apiKey: String): MoviesResponse*/
}