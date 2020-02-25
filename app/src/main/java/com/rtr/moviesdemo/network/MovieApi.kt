package com.rtr.moviesdemo.network

import com.rtr.moviesdemo.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(@Query("api_key") apiKey: String): MoviesResponse
}