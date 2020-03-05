package com.rtr.moviesdemo

import android.view.View
import com.rtr.moviesdemo.model.HomeDataModel

object Constants {
    const val RESULT: String ="result"
    const val apiKey = "53a3d153f59ecba4fa2135d7af73d3f7"
    const val baseUrl = "https://api.themoviedb.org/3/"
    val homeDataArrayList = ArrayList<HomeDataModel>()

    init {
        addMovieData(1, "Now Playing", "movie/now_playing")
        addMovieData(2, "Upcoming Movies", "movie/upcoming")
        addMovieData(3, "Popular Movies", "movie/popular")
        addMovieData(4, "Top Rated", "movie/top_rated")
        addMovieData(5, "TV Airing Today", "tv/airing_today")
        addMovieData(6, "TV Top Rated", "tv/top_rated")
        addMovieData(7, "TV On Air", "tv/on_the_air")
        addMovieData(8, "TV Popular", "tv/popular")


    }

    fun addMovieData(id: Long, category: String, urlName: String) {
        homeDataArrayList.add(
            HomeDataModel(
                id = id,
                category = category,
                dataArrayList = null,
                progressVisibility = View.VISIBLE,
                url = baseUrl + urlName
            )
        )
    }
}