package com.rtr.moviesdemo.model


data class MoviesResponse(
    val dates: Dates? = null,
    val page: Int = 0,
    val results: ArrayList<Result>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)