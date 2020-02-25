package com.rtr.moviesdemo.model


data class MoviesResponse(
    val dates: Dates?= null,
    val page: Int= 0,
    val movies: List<Movie>? =null,
    val total_pages: Int? = null,
    val total_results: Int?= null
)