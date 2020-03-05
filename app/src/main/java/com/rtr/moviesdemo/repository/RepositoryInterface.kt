package com.rtr.moviesdemo.repository

import com.rtr.moviesdemo.model.MoviesResponse
import com.rtr.moviesdemo.network.ResultWrapper

interface RepositoryInterface {
   suspend fun getMovies(url:String): ResultWrapper<MoviesResponse>

   /*suspend fun getNowPlayingMovies(): ResultWrapper<MoviesResponse>*/
}