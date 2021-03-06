package com.rtr.moviesdemo.repository

import com.rtr.moviesdemo.Constants
import com.rtr.moviesdemo.model.MoviesResponse
import com.rtr.moviesdemo.network.MovieApi
import com.rtr.moviesdemo.network.ResultWrapper
import com.rtr.moviesdemo.network.safeApiCall
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class RepositoryImp(private val movieApi: MovieApi, private val dispatcher: CoroutineDispatcher = Dispatchers.IO) : RepositoryInterface {
    override suspend fun getMovies(url:String): ResultWrapper<MoviesResponse> {

        return safeApiCall(dispatcher) { movieApi.getUpcomingMovie(url, Constants.apiKey) }
    }

   /* override suspend fun getNowPlayingMovies(): ResultWrapper<MoviesResponse> {
        return safeApiCall(dispatcher) {
            movieApi.getNowPlaying(apiKey = Constants.apiKey)
        }
    }*/
}


