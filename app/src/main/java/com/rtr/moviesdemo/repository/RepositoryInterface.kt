package com.rtr.moviesdemo.repository

import com.rtr.moviesdemo.model.MoviesResponse
import com.rtr.moviesdemo.network.ResultWrapper

interface RepositoryInterface {
   suspend fun getUpcomingMovie(): ResultWrapper<MoviesResponse>
}